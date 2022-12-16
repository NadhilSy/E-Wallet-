package org.nadhil.project.springboot.service.customerbank;

import org.nadhil.project.springboot.model.customerbank.CustomerBank;

import java.util.List;

public interface ICustomerBankService {
    CustomerBank registerBank(CustomerBank customerBank);

    List<CustomerBank> getList();

}
