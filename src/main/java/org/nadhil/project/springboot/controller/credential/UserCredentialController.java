package org.nadhil.project.springboot.controller.credential;

import org.modelmapper.ModelMapper;
import org.nadhil.project.springboot.dto.credential.UserCredentialRequest;
import org.nadhil.project.springboot.model.credential.UserCredential;
import org.nadhil.project.springboot.response.ErrorResponse;
import org.nadhil.project.springboot.response.SuccessResponse;
import org.nadhil.project.springboot.service.credential.IUserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/credentials")
@Validated
public class UserCredentialController {

    private ModelMapper modelMapper;
    private IUserCredentialService service;

    public UserCredentialController(@Autowired ModelMapper modelMapper,@Autowired IUserCredentialService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getCredential(@Valid @RequestBody UserCredentialRequest request){
        try {
            UserCredential getCredential = modelMapper.map(request, UserCredential.class);
            UserCredential result = service.getBy(getCredential);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("00","success", result));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("xx", e.getMessage()));
        }
    }

}
