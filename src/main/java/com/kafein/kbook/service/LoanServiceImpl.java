package com.kafein.kbook.service;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.mapper.LoanMapper;
import com.kafein.kbook.model.User;
import com.kafein.kbook.repository.LoanRepository;
import com.kafein.kbook.repository.UserRepository;
import com.kafein.kbook.service.base.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanMapper loanMapper;


    @Override
    public LoanDTO save(LoanDTO loanDTO) {
        for (User user: userRepository.findAll()){
            if (((User)(((ArrayList)loanDTO.getUsers()).get(0))).getId().equalsIgnoreCase(user.getId())){
                return null;
            }
        }
        return loanMapper.toLoanDTO(loanRepository.save(loanMapper.toLoan(loanDTO)));
    }

    @Override
    public List<LoanDTO> findAll() {
        return loanMapper.toLoanDTOList(loanRepository.findAll());
    }
}
