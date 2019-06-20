package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.AuthorDTO;
import com.kafein.kbook.model.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {

    Author save(AuthorDTO author);

    List<AuthorDTO> findAll();

}
