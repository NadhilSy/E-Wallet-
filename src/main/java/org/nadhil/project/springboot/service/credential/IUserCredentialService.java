package org.nadhil.project.springboot.service.credential;

import org.nadhil.project.springboot.model.credential.UserCredential;

public interface IUserCredentialService {

    UserCredential registerCredential(UserCredential userCredential);

    UserCredential getId(String id);

    UserCredential getBy(UserCredential context);
}
