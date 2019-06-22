package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    BookDTO save(BookDTO bookDTO);

    List<BookDTO> findAll();

    BookDTO findById(int id);

    List<BookDTO> findAllByName(String name);

    List<BookDTO> findAllByAuthor_FnameAndAuthor_Lname(String author_fname, String author_lname);

    List<BookDTO> findAllByPublisher_Name(String name);

    List<BookDTO> findAllByType_Name(String name);

}
