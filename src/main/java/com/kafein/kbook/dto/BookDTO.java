package com.kafein.kbook.dto;

import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {

    private int id;

    private String name;

    private BookTypeDTO type;

    private int editionYear;

    private String isbn;

    private boolean hardcover;

    private int nop;

    private AuthorDTO author;

    private Set<PublisherDTO> publishers;

    private boolean status;

    private LoanDTO loan;

}
