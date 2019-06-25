package com.kafein.kbook.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class LoanDTO implements Serializable {

    private int id;

    private Set<BookDTO> books;

    private UserDTO user;

    private Date pickDate;

    private Date deliveryDate;

    private Date maxDate;

}
