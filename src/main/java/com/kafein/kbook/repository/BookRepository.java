package com.kafein.kbook.repository;

import com.kafein.kbook.model.Book;
import com.kafein.kbook.model.BookType;
import com.kafein.kbook.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByName(String name);

    List<Book> findAllByAuthor_FnameAndAuthor_Lname(String author_fname, String author_lname);

    List<Book> findAllByPublishers_Name(String name);

    List<Book> findAllByType_Name(String name);


}
