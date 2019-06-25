package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.LoanDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoanService {

    LoanDTO save(LoanDTO loanDTO);

    List<LoanDTO> findAll();

    void deleteAllById(int id);

    LoanDTO findById(int id);

}
