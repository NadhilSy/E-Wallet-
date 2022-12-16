package org.nadhil.project.springboot.repository.account;

import org.nadhil.project.springboot.model.account.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountRepository extends JpaRepository<UserAccount, String> {
}
