package com.kafein.kbook.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookTypeDTO implements Serializable {

    private int id;

    private String name;

}
