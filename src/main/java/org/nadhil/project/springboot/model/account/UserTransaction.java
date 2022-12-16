package org.nadhil.project.springboot.model.account;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_user_transaction")
public class UserTransaction {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid" ,strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "balance_id")
    private UserBalance userBalance;

    @Column(name = "topup_value", nullable = false)
    private Long topUpValue;
    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

}
