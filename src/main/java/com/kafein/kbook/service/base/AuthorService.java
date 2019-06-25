package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.AuthorDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {

    AuthorDTO save(AuthorDTO author);

    List<AuthorDTO> findAll();

    AuthorDTO findById(int id);

    List<AuthorDTO> findAllByFname(String fname);

    List<AuthorDTO> findAllByLname(String lname);

    List<AuthorDTO> findAllByFnameAndLname(String fname, String lname);

}
