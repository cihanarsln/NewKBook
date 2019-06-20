package com.kafein.kbook.dto;

import java.util.Date;
import java.util.Set;

public class LoanDTO {

    private int id;

    private Date pickDate;

    private Set<BookDTO> books;

    private Set<UserDTO> users;

}
