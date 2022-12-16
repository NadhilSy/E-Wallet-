package org.nadhil.project.springboot.model.account;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.nadhil.project.springboot.model.credential.UserCredential;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", unique = true)
    private UserCredential userCredential;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "balance_id")
    private UserBalance balanceId;





//    @Column(name = "debit_id", nullable = true, length = 20)
//    private String debitId;
//    @Column(name = "balance", nullable = true)
//    private Long balance;
}
