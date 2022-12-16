package org.nadhil.project.springboot.dto.account;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserAccountRequest{

    private String firstName;
    private String lastName;

}
