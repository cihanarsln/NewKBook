package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String address;

    private String phone;

    @ManyToMany(mappedBy = "publishers")
    private Set<Book> books;

}
