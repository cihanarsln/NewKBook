package com.kafein.kbook.repository;

import com.kafein.kbook.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    void deleteById(int id);

}