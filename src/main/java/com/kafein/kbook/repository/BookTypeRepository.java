package com.kafein.kbook.repository;

import com.kafein.kbook.model.Book;
import com.kafein.kbook.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookTypeRepository extends JpaRepository<BookType, Integer> {

    List<BookType> findByName(String name);

}
