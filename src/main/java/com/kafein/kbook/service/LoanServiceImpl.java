package com.kafein.kbook.service;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.mapper.LoanMapper;
import com.kafein.kbook.model.Loan;
import com.kafein.kbook.repository.LoanRepository;
import com.kafein.kbook.service.base.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanMapper loanMapper;


    @Override
    public Loan save(LoanDTO loanDTO) {
        return loanRepository.save(loanMapper.toLoan(loanDTO));
    }

    @Override
    public List<LoanDTO> findAll() {
        return loanMapper.toLoanDTOList(loanRepository.findAll());
    }
}
