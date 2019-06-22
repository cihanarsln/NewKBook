package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private BookType type;

    private int editionYear;

    private String isbn;

    private boolean hardcover;

    private int nop;

    @ManyToOne
    private Author author;


    @ManyToOne
    private Publisher publisher;

    @ManyToMany(mappedBy = "books")
    private Set<Loan> loans;

}
