package org.nadhil.project.springboot.model.credential;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.nadhil.project.springboot.model.account.UserAccount;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "user_credential")
public class UserCredential {

//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
//    private String id;


    @Id
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;


}
