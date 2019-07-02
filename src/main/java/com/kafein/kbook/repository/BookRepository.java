package com.kafein.kbook.repository;

import com.kafein.kbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByName(String name);

    List<Book> findAllByAuthor_Id(int id);

    Book findById(int id);

    List<Book> findAllByAuthor_FnameAndAuthor_Lname(String author_fname, String author_lname);

    List<Book> findAllByPublisher_Name(String name);

    List<Book> findAllByType_Name(String name);


}
