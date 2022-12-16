package org.nadhil.project.springboot.service.account;

import org.nadhil.project.springboot.exception.NotFoundException;
import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.repository.account.IUserBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
@Transactional
public class UserBalanceService implements IUserBalanceService {

    private IUserBalanceRepository userBalanceRepository;


    public UserBalanceService(@Autowired IUserBalanceRepository userBalanceRepository) {
        this.userBalanceRepository = userBalanceRepository;
    }

    @Override
    public UserBalance registerBalance(UserBalance userBalance) {
        try {
            return userBalanceRepository.save(userBalance);
        } catch (Exception e){
            throw new EntityExistsException();
        }
    }

    @Override
    public UserBalance getId(String id) {
        Optional<UserBalance> balanceId = userBalanceRepository.findById(id);
        if (balanceId.isEmpty()){
            throw new NotFoundException("user id not create");
        }
        return balanceId.get();
    }
}
