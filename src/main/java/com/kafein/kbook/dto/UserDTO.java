package com.kafein.kbook.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private String id;

    private String fname;

    private String lname;

    private String phone;

    private String address;

    private Date bdate;

}
