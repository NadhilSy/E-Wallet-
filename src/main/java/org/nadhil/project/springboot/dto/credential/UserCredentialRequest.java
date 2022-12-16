package org.nadhil.project.springboot.dto.credential;

import lombok.Data;

import javax.persistence.Column;


@Data
public class UserCredentialRequest {

    private String email;
    private String password;
}
