package org.nadhil.project.springboot.service.account;

import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.credential.UserCredential;

public interface IUserAccountService {
    UserAccount registerAccount(UserAccount userAccount, UserCredential userCredential);
}
