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
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        User theUser = loan.getUsers().iterator().next();
        Set<Book> selectableBooks = getSelectableBooks(loan.getBooks());

        for (User user : userRepository.findAll()){
            if (user.getId().equalsIgnoreCase(theUser.getId())){
                if(selectableBooks.size()>0){
                    loan.setBooks(selectableBooks);
                    loanRepository.save(loan);
                    return loanMapper.toLoanDTO(loan);
                }
            }
        }
        userRepository.save(theUser);
        loan.setBooks(selectableBooks);
        return loanMapper.toLoanDTO(loan);
       // return loanMapper.toLoanDTO(loanRepository.save(loanMapper.toLoan(loanDTO)));
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

    private Set<Book> getSelectableBooks(Set<Book> books){
        Set<Book> selectableBooks = new HashSet<>();
        for (Book book : books) {
            Book theBook = bookRepository.findById(book.getId());
            if (theBook.getStatus()){
                theBook.setStatus(false);
                selectableBooks.add(theBook);
            }
        }
        bookRepository.saveAll(selectableBooks);
        return selectableBooks;
    }

}
