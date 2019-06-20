package com.kafein.kbook.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date pickDate;

    @OneToMany
    private Set<Book> books;

    @OneToMany
    private Set<User> users;

}
