package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Book {

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

    @ManyToMany
    @JoinTable(name = "publisher_books",
            joinColumns = @JoinColumn(name = "books_id", referencedColumnName = "id", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "publishers_id", referencedColumnName = "id", insertable = false, updatable = false))
    private Set<Publisher> publishers;

    private boolean status;

}
