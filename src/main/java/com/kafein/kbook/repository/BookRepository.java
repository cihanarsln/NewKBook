package com.kafein.kbook.repository;

import com.kafein.kbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByName(String name);

    Book findById(int id);

    List<Book> findAllByAuthor_FnameAndAuthor_Lname(String author_fname, String author_lname);

    List<Book> findAllByPublishers_Name(String name);

    List<Book> findAllByType_Name(String name);


}
