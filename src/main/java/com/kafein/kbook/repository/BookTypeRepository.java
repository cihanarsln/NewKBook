package com.kafein.kbook.repository;

import com.kafein.kbook.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Integer> {

    List<BookType> findByName(String name);

}
