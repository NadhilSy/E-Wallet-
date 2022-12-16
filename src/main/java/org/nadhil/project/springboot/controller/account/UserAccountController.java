package org.nadhil.project.springboot.controller.account;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.nadhil.project.springboot.dto.account.UserAccountCredRequest;
import org.nadhil.project.springboot.model.account.UserAccount;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.response.ErrorResponse;
import org.nadhil.project.springboot.response.SuccessResponse;
import org.nadhil.project.springboot.service.account.IUserAccountService;
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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            UserAccount newAccount = modelMapper.map(request, UserAccount.class);
            UserCredential newCredential = modelMapper.map(request, UserCredential.class);
            System.out.println(newAccount);
            System.out.println(newCredential);

            UserAccount result = service.registerAccount(newAccount, newCredential);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","Success Create Account", result));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", e.getMessage()));
        }
    }

}
