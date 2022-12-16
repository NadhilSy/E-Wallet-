package org.nadhil.project.springboot.service.account;

import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.model.customerbank.CustomerBank;

import java.util.List;

public interface IUserAccountService {
    UserAccount registerAccount(UserAccount userAccount, UserCredential userCredential, UserBalance userBalance);

    List<UserAccount> getList();

//    UserAccount updateDebit(UserAccount request, String id);
}
