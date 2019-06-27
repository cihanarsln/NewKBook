package com.kafein.kbook.dto;

import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
public class UserDTO {

    private String id;

    private String fname;

    private String lname;

    private String username;

    private String password;

    private Set<RoleDTO> roles;

    private String phone;

    private String address;

    private Date bdate;

    private String mail;

}
