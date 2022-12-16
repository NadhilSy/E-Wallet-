package org.nadhil.project.springboot.repository.account;

import org.nadhil.project.springboot.model.account.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserBalanceRepository extends JpaRepository<UserBalance, String> {
}
