package com.kafein.kbook.service;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.mapper.LoanMapper;
import com.kafein.kbook.model.Loan;
import com.kafein.kbook.repository.BookRepository;
import com.kafein.kbook.repository.LoanRepository;
import com.kafein.kbook.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceImplTest {

    @InjectMocks
    private LoanServiceImpl loanServiceImpl;

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private LoanMapper loanMapper;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllTest(){
        when(loanMapper.toLoanDTOList(loanRepository.findAll())).thenReturn(createLoanDTOList());
        Assert.assertEquals(loanServiceImpl.findAll(), createLoanDTOList());
    }


    @Test
    public void findByIdTest(){
        when(loanMapper.toLoanDTO(loanRepository.findById(anyInt()))).thenReturn(createLoanDTO());
        Assert.assertEquals(1,loanServiceImpl.findById(anyInt()).getId());
    }

    @Test
    public void findAllByUser_IdTest(){
        when(loanMapper.toLoanDTOList(loanRepository.findAllByUser_Id(anyString()))).thenReturn(createLoanDTOList());
        Assert.assertEquals(1, loanServiceImpl.findAllByUser_Id(anyString()).size());
    }

    private LoanDTO createLoanDTO() {
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setId(1);
        return loanDTO;
    }

    public List<LoanDTO> createLoanDTOList(){
        List<LoanDTO> loanDTOs = new ArrayList<>();
        loanDTOs.add(createLoanDTO());
        return loanDTOs;
    }

    public List<LoanDTO> createLoanDTOListWithOnlyUser(){
        List<LoanDTO> loanDTOs = new ArrayList<>();
        LoanDTO loanDTO = new LoanDTO();
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        loanDTO.setUser(userDTO);
        loanDTOs.add(createLoanDTO());
        return loanDTOs;
    }




}
