package org.nadhil.project.springboot.repository.account;

import org.nadhil.project.springboot.model.account.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserAccountRepository extends JpaRepository<UserAccount, String> {

    @Query("select s from UserAccount s where s.id = ?1")
    Optional<UserAccount> existUser(String s);

}
