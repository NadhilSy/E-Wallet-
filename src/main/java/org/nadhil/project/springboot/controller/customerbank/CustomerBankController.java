package org.nadhil.project.springboot.controller.customerbank;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.nadhil.project.springboot.dto.account.UserAccountCredRequest;
import org.nadhil.project.springboot.dto.customerbank.CustomerBankRequest;
import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.model.customerbank.CustomerBank;
import org.nadhil.project.springboot.response.ErrorResponse;
import org.nadhil.project.springboot.response.SuccessResponse;
import org.nadhil.project.springboot.service.customerbank.ICustomerBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerBankController {

    private ModelMapper modelMapper;
    private ICustomerBankService service;

    public CustomerBankController(@Autowired ModelMapper modelMapper,@Autowired ICustomerBankService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerBankRequest request){
        try {
            CustomerBank newCustomer = modelMapper.map(request, CustomerBank.class);
            CustomerBank result = service.registerBank(newCustomer);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","Success Create Customer", result));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity getAllCustomer(){
        try {
            List<CustomerBank> customers = service.getList();
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","Success get Profiles", customers));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X02", e.getMessage()));
        }
    }
}
