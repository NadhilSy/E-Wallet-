package org.nadhil.project.springboot.repository.account;

import org.nadhil.project.springboot.model.account.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTransactionRepository extends JpaRepository<UserTransaction, String> {
}
