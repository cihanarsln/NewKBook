package com.kafein.kbook.service;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.mapper.LoanMapper;
import com.kafein.kbook.model.Book;
import com.kafein.kbook.model.Loan;
import com.kafein.kbook.model.User;
import com.kafein.kbook.repository.BookRepository;
import com.kafein.kbook.repository.LoanRepository;
import com.kafein.kbook.repository.UserRepository;
import com.kafein.kbook.service.base.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanMapper loanMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoanDTO save(LoanDTO loanDTO) {

        Loan loan = loanMapper.toLoan(loanDTO);
        User theUser = loan.getUser();
        Set<Book> theBooks = getBooks(loan.getBooks());
        User user1 = saveUser(theUser);
        loan.setBooks(theBooks);
        loan.setMaxDate(calculateUsaageTime(theBooks, loan.getPickDate()));
        return loanMapper.toLoanDTO(loanRepository.save(loan));

    }

    @Override
    public List<LoanDTO> findAll() {
        return loanMapper.toLoanDTOList(loanRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteAllById(int id) {
        loanRepository.deleteAllById(id);
    }

    @Override
    public LoanDTO findById(int id) {
        return loanMapper.toLoanDTO(loanRepository.findById(id));
    }

    @Override
    public List<LoanDTO> findAllByUser_Id(String id) {
        return loanMapper.toLoanDTOList(loanRepository.findAllByUser_Id(id));
    }

    @Override
    public LoanDTO deliver(int id) {
        Loan loan = loanRepository.findById(id);
        loan.setDeliveryDate(new Date());
        deliverBooks(loan.getBooks());
        return loanMapper.toLoanDTO(loanRepository.save(loan));
    }

    private Set<Book> getBooks(Set<Book> books){
        Set<Book> theBooks = new HashSet<>();
        for (Book book : books) {
            Book theBook = bookRepository.findById(book.getId());
            if (theBook.getStatus()){
                theBook.setStatus(false);
                theBooks.add(theBook);
            }
        }
        bookRepository.saveAll(theBooks);
        return theBooks;
    }

    private User saveUser(User theUser){
        for (User user : userRepository.findAll()){
            if (user.getId().equalsIgnoreCase(theUser.getId())){
                return theUser;
            }
        }
        return userRepository.save(theUser);
    }

    private Date calculateUsaageTime(Set<Book> books, Date date){
        int totalPages = 0;
        for (Book book : books) totalPages += book.getNop();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, totalPages/50);
        return calendar.getTime();
    }

    private void deliverBooks(Set<Book> books){
        Set<Book> theBooks = new HashSet<>();
        for (Book book : books){
            Book theBook = bookRepository.findById(book.getId());
            theBook.setStatus(true);
            theBooks.add(theBook);
        }
        bookRepository.saveAll(theBooks);
    }
}
