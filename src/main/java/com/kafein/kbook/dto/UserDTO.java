package com.kafein.kbook.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserDTO {

    private String id;

    private String fname;

    private String lname;

    private String username;

    private String password;

    private String phone;

    private String address;

    private Date bdate;

    private String mail;

    private Boolean enabled;

    private Set<RoleDTO> roles;

}
