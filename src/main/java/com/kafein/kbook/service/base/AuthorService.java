package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.AuthorDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {

    AuthorDTO save(AuthorDTO author);

    List<AuthorDTO> findAll();

}
