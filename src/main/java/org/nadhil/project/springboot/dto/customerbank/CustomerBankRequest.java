package org.nadhil.project.springboot.dto.customerbank;

import lombok.Data;

@Data
public class CustomerBankRequest {
    private String debitId;

    private String pin;

    private Long balance;
}
