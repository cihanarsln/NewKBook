package com.kafein.kbook.repository;

import com.kafein.kbook.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {



}
