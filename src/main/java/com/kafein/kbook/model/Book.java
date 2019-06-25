package com.kafein.kbook.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    private Boolean hardcover;

    private int nop;

    @ManyToOne
    private Author author;

    private Boolean status;

    @ManyToOne
    private Publisher publisher;

}
