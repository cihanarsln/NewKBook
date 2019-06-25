package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    private String id;

    private String fname;

    private String lname;

    private String phone;

    private String address;

    private Date bdate;

}
