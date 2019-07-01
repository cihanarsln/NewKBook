package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
public class User implements Serializable {

    @Id
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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

}
