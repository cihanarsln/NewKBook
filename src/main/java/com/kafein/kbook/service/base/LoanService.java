package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.model.Loan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoanService {

    Loan save(LoanDTO loanDTO);

    List<LoanDTO> findAll();

}
