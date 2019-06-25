package com.kafein.kbook.repository;

import com.kafein.kbook.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

        void deleteAllById(int id);

        Loan findById(int id);

}
