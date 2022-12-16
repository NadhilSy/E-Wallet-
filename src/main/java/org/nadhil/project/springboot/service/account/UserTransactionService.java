package org.nadhil.project.springboot.service.account;

import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.account.UserTransaction;
import org.nadhil.project.springboot.repository.account.IUserTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

@Service
@Transactional
public class UserTransactionService implements IUserTransactionService{

    @Autowired IUserBalanceService userBalanceService;
    @Autowired IUserTransactionRepository userTransactionRepository;


    @Override
    public UserTransaction createTransaction(UserTransaction userTransaction, String id) {
        try {
            return null;

        } catch (Exception e){
            throw new EntityExistsException();
        }

    }
}
