package org.nadhil.project.springboot.controller.account;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.nadhil.project.springboot.dto.account.UserAccountCredRequest;
import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.account.UserBalance;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.model.customerbank.CustomerBank;
import org.nadhil.project.springboot.response.ErrorResponse;
import org.nadhil.project.springboot.response.SuccessResponse;
import org.nadhil.project.springboot.service.account.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserAccountController {

    private ModelMapper modelMapper;
    private IUserAccountService service;

    public UserAccountController(@Autowired ModelMapper modelMapper,@Autowired IUserAccountService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createAccount(@Valid @RequestBody UserAccountCredRequest request){
        try {
//            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            UserAccount newAccount = modelMapper.map(request, UserAccount.class);
            UserCredential newCredential = modelMapper.map(request, UserCredential.class);
            UserBalance newBalance = modelMapper.map(request, UserBalance.class);


            UserAccount result = service.registerAccount(newAccount, newCredential, newBalance);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","Success Create Account", result));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", e.getMessage()));
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity updateDebit(@Valid @RequestBody UserAccountDebitRequest request, @PathVariable("id") String id){
//        try {
//            UserAccount userAccount = modelMapper.map(request, UserAccount.class);
//            UserAccount result = service.updateDebit(userAccount, id);
//            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","SUccess", result));
//        } catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", e.getMessage()));
//        }
//    }

    @GetMapping
    public ResponseEntity getListAccount(){
        try {
            List<UserAccount> userAccounts = service.getList();
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","Success get Profiles", userAccounts));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X02", e.getMessage()));
        }
    }

}
