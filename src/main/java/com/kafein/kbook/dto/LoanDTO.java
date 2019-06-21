package com.kafein.kbook.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class LoanDTO implements Serializable {

    private int id;

    private List<BookDTO> books;

    private UserDTO user;

}
