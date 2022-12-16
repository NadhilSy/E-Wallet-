package org.nadhil.project.springboot.model.customerbank;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer_profile")
public class CustomerBank {

    @Id
    @Column(name = "debit_id", nullable = false, length = 20, unique = true)
    private String debitId;

    @Column(name = "pin", nullable = false, length = 10)
    private String pin;

    @Column(name = "balance", nullable = false)
    private Long balance;


}
