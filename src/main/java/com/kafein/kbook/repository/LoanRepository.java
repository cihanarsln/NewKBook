package com.kafein.kbook.repository;

import com.kafein.kbook.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

        void deleteAllById(int id);

        Loan findById(int id);

        List<Loan> findAllByUser_Id(String id);

}
