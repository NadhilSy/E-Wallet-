package org.nadhil.project.springboot.controller.transaction;

import org.modelmapper.ModelMapper;
import org.nadhil.project.springboot.dto.account.UserAccountCredRequest;
import org.nadhil.project.springboot.dto.account.UserTransactionRequest;
import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.account.UserTransaction;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.response.ErrorResponse;
import org.nadhil.project.springboot.response.SuccessResponse;
import org.nadhil.project.springboot.service.account.IUserAccountService;
import org.nadhil.project.springboot.service.account.IUserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
@Validated
public class UserTransactionController {

    private ModelMapper modelMapper;
    private IUserTransactionService service;

    public UserTransactionController(@Autowired ModelMapper modelMapper,@Autowired IUserTransactionService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createTransaction(@Valid @RequestBody UserTransactionRequest request, String id){
        try {
//            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//            UserAccount newAccount = modelMapper.map(request, UserAccount.class);
//            UserCredential newCredential = modelMapper.map(request, UserCredential.class);
//            UserBalance newBalance = modelMapper.map(request, UserBalance.class);

            UserTransaction newTransaction = modelMapper.map(request, UserTransaction.class);
            UserTransaction result = service.createTransaction(newTransaction, id);


//            UserAccount result = service.registerAccount(newAccount, newCredential, newBalance);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","Success Create Account", result));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", e.getMessage()));
        }
    }

}
