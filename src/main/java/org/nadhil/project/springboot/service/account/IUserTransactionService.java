package org.nadhil.project.springboot.service.account;


import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.account.UserTransaction;

public interface IUserTransactionService {
    UserTransaction createTransaction(UserTransaction userTransaction, String id);
}
