package com.kafein.kbook.repository;

import com.kafein.kbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
