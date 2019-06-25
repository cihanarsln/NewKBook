package com.kafein.kbook.repository;

import com.kafein.kbook.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findById(int id);

    List<Author> findAllByFname(String fname);

    List<Author> findAllByLname(String lname);

    List<Author> findAllByFnameAndLname(String fname, String lname);

}
