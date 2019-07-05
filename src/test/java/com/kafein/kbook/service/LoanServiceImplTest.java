package com.kafein.kbook.service;

import com.kafein.kbook.dto.BookDTO;
import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.mapper.LoanMapper;
import com.kafein.kbook.model.Book;
import com.kafein.kbook.model.Loan;
import com.kafein.kbook.model.User;
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
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

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
        when(loanMapper.toLoanDTOList(loanRepository.findAll())).thenReturn(createLoanList());
        Assert.assertEquals(loanServiceImpl.findAll(), createLoanList());
    }

    public List<LoanDTO> createLoanList(){
        UserDTO user = new UserDTO();
        user.setId("1");
        BookDTO book = new BookDTO();
        book.setId(1);
        Set<BookDTO> books = new HashSet<>();
        books.add(book);
        LoanDTO loan = new LoanDTO();
        loan.setId(1);
        loan.setUser(user);
        loan.setBooks(books);
        loan.setDeliveryDate(new Date(2000,10,10));
        loan.setMaxDate(new Date(2000,10,10));
        loan.setPickDate(new Date(2000,10,10));
        List<LoanDTO> loans = new ArrayList<>();
        loans.add(loan);
        return loans;
    }



}
