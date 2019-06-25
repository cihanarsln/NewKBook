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

    //@OneToMany
    //private Set<Book> books;

    //@OneToOne
    //private User user;

    /*@ManyToMany
    @JoinTable(name = "loan_books",
            joinColumns = @JoinColumn(name = "loan_id", referencedColumnName = "id", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", insertable = false, updatable = false))
    private Set<Book> books;*/

    /*@ManyToMany
    @JoinTable(name = "loan_users",
            joinColumns = @JoinColumn(name = "loan_id", referencedColumnName = "id", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false))
    private Set<User> users;*/

    @ManyToMany
    private Set<User> users;

    @ManyToMany
    private Set<Book> books;

    private Date pickDate;

    private Date deliveryDate;

}
