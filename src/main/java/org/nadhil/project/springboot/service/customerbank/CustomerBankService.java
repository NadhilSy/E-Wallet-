package org.nadhil.project.springboot.service.customerbank;

import org.nadhil.project.springboot.model.customerbank.CustomerBank;
import org.nadhil.project.springboot.repository.customerbank.ICustomerBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
@Transactional
public class CustomerBankService implements ICustomerBankService{

    private ICustomerBankRepository customerBankRepository;

    public CustomerBankService(@Autowired ICustomerBankRepository customerBankRepository) {
        this.customerBankRepository = customerBankRepository;
    }

    @Override
    public CustomerBank registerBank(CustomerBank customerBank) {
        try {
            return customerBankRepository.save(customerBank);
        } catch (Exception e){
            throw new EntityExistsException();
        }
    }

    @Override
    public List<CustomerBank> getList() {
        List<CustomerBank> customerList = customerBankRepository.findAll();
        return customerList;
    }
}
