package org.nadhil.project.springboot.service.credential;

import org.nadhil.project.springboot.exception.NotFoundException;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.repository.credential.IUserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
@Transactional
public class UserCredentialService implements IUserCredentialService {

    private IUserCredentialRepository userCredentialRepository;

    public UserCredentialService(@Autowired IUserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Override
    public UserCredential registerCredential(UserCredential userCredential) {
        try {
            return userCredentialRepository.save(userCredential);
        } catch (Exception e){
            throw new EntityExistsException();
        }
    }

    @Override
    public UserCredential getId(String id) {
        Optional<UserCredential> credentialId = userCredentialRepository.findById(id);
        if (credentialId.isEmpty()){
            throw new NotFoundException("user id not create");
        }
        return credentialId.get();
    }

    @Override
    public UserCredential getBy(UserCredential context) {
        Optional<UserCredential> credential = userCredentialRepository.findById(context.getEmail());
        if (credential.isEmpty()){

        }
        return credential.get();
    }
}
