package org.nadhil.project.springboot.repository.customerbank;

import org.nadhil.project.springboot.model.customerbank.CustomerBank;
import org.nadhil.project.springboot.service.customerbank.CustomerBankService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerBankRepository extends JpaRepository<CustomerBank, String> {
}
