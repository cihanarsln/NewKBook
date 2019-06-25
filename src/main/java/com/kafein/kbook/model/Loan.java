package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Book> books;

    private Date pickDate;

    private Date deliveryDate;

    private Date maxDate;

}
