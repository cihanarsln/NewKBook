package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.BookDTO;
import com.kafein.kbook.model.Book;
import com.kafein.kbook.model.BookType;
import com.kafein.kbook.model.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    Book save(BookDTO bookDTO);

    List<BookDTO> findAll();

    List<BookDTO> findAllByName(String name);

    List<BookDTO> findAllByAuthor_FnameAndAuthor_Lname(String author_fname, String author_lname);

    List<BookDTO> findAllByPublishers_Name(String name);

    List<BookDTO> findAllByType_Name(String name);

}
