package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String address;

    private String phone;

}
