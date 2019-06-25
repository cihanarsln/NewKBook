package com.kafein.kbook.dto;

import lombok.Data;

@Data
public class BookDTO {

    private int id;

    private String name;

    private BookTypeDTO type;

    private int editionYear;

    private String isbn;

    private Boolean hardcover;

    private Boolean status;

    private int nop;

    private AuthorDTO author;

    private PublisherDTO publisher;

}
