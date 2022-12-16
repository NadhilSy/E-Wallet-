package org.nadhil.project.springboot.dto.account;

import lombok.Data;


@Data
public class UserAccountDebitRequest {

    private String firstName;
    private String lastName;
    private String debitId;
    private String password;
}
