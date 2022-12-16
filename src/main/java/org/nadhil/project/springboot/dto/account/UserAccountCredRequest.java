package org.nadhil.project.springboot.dto.account;

import lombok.Data;
import org.nadhil.project.springboot.dto.credential.UserCredentialRequest;

@Data
public class UserAccountCredRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String balance;

    private String debit;
}
