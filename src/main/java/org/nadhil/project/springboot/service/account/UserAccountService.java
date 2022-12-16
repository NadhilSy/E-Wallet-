package org.nadhil.project.springboot.service.account;

import org.modelmapper.ModelMapper;
import org.nadhil.project.springboot.exception.NotFoundException;
import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.repository.account.IUserAccountRepository;
import org.nadhil.project.springboot.service.credential.IUserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserAccountService implements IUserAccountService{
    private IUserCredentialService userCredentialService;
    private IUserAccountRepository userAccountRepository;
    private IUserBalanceService userBalanceService;
    private ModelMapper modelMapper;

    public UserAccountService(
            @Autowired IUserCredentialService userCredentialService,
            @Autowired IUserAccountRepository userAccountRepository,
            @Autowired IUserBalanceService userBalanceService,
            @Autowired ModelMapper modelMapper
    ) {
        this.userCredentialService = userCredentialService;
        this.userAccountRepository = userAccountRepository;
        this.userBalanceService = userBalanceService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserAccount registerAccount(UserAccount userAccount, UserCredential userCredential, UserBalance userBalance) {
        try {
            UserCredential newUserCred = userCredentialService.registerCredential(userCredential);
            UserCredential credentialId = userCredentialService.getId(newUserCred.getEmail());
            UserBalance newUserBalance = userBalanceService.registerBalance(userBalance);
            UserBalance balanceId = userBalanceService.getId(newUserBalance.getId());

            userAccount.setUserCredential(credentialId);
            userAccount.setBalanceId(balanceId);

            return userAccountRepository.save(userAccount);
        } catch (DataIntegrityViolationException e){
            throw new EntityExistsException();
        }
    }

    @Override
    public List<UserAccount> getList() {
        List<UserAccount> accountList = userAccountRepository.listOfUser();
        return accountList;
    }

    //    @Override
//    public UserAccount updateDebit(UserAccount userAccount, String id) {
//        try {
//            System.out.println("UUUUUU " + userAccount);
//            Optional<UserAccount> existingUser = userAccountRepository.existUser(id);
//            System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT" + existingUser);
////            modelMapper.map(userAccount, existingUser);
////            userAccount.setDebitId(existingUser.getDebitId());
//            userAccount.setDebitId(existingUser.get().getDebitId());
//
//            return userAccountRepository.save(userAccount);
//        } catch (NotFoundException e){
//            throw new NotFoundException("failed");
//        }
//    }
    public UserAccount getId(String id) {
        Optional<UserAccount> accountlId = userAccountRepository.findById(id);
        if (accountlId.isEmpty()){
            throw new NotFoundException("user id not create");
        }
        return accountlId.get();
    }
}
