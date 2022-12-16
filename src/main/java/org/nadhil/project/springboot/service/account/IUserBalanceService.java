package org.nadhil.project.springboot.service.account;

import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.credential.UserCredential;

public interface IUserBalanceService {

    UserBalance registerBalance(UserBalance userBalance);

    UserBalance getId(String id);
}
