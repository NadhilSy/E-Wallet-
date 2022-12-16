package org.nadhil.project.springboot.service.account;

import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.repository.account.IUserAccountRepository;
import org.nadhil.project.springboot.service.credential.IUserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

@Service
@Transactional
public class UserAccountService implements IUserAccountService{
    private IUserCredentialService userCredentialService;
    private IUserAccountRepository userAccountRepository;

    public UserAccountService(@Autowired IUserCredentialService userCredentialService,@Autowired IUserAccountRepository userAccountRepository) {
        this.userCredentialService = userCredentialService;
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public UserAccount registerAccount(UserAccount userAccount, UserCredential userCredential) {
        try {
            UserCredential newUserCred = userCredentialService.registerCredential(userCredential);
            System.out.println(newUserCred.getId());
            UserCredential credentialId = userCredentialService.getId(newUserCred.getId());
            userAccount.setUserCredential(credentialId);
            return userAccountRepository.save(userAccount);
        } catch (DataIntegrityViolationException e){
            throw new EntityExistsException();
        }
    }
}
