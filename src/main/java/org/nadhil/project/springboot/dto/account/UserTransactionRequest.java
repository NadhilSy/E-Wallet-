package org.nadhil.project.springboot.dto.account;

import lombok.Data;
import org.nadhil.project.springboot.model.account.UserBalance;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Data
public class UserTransactionRequest {
    private Long topUpValue;

}
