package com.kafein.kbook.service;

import com.kafein.kbook.model.BookType;
import com.kafein.kbook.model.Publisher;
import com.kafein.kbook.service.base.BookService;
import com.kafein.kbook.dto.BookDTO;
import com.kafein.kbook.mapper.BookMapper;
import com.kafein.kbook.model.Book;
import com.kafein.kbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book save(BookDTO bookDTO) {
        return bookRepository.save(bookMapper.toBook(bookDTO));
    }

    @Override
    public List<BookDTO> findAll() {
        return bookMapper.toBookDTOList(bookRepository.findAll());
    }

    @Override
    public BookDTO findById(int id) {
        return bookMapper.toBookDTO(bookRepository.findById(id));
    }

    @Override
    public List<BookDTO> findAllByName(String name) {
        return bookMapper.toBookDTOList(bookRepository.findAllByName(name));
    }

    @Override
    public List<BookDTO> findAllByAuthor_FnameAndAuthor_Lname(String author_fname, String author_lname) {
        return bookMapper.toBookDTOList(bookRepository.findAllByAuthor_FnameAndAuthor_Lname(author_fname, author_lname));
    }

    @Override
    public List<BookDTO> findAllByPublishers_Name(String name) {
        return bookMapper.toBookDTOList(bookRepository.findAllByPublishers_Name(name));
    }


    @Override
    public List<BookDTO> findAllByType_Name(String name) {
        return bookMapper.toBookDTOList(bookRepository.findAllByType_Name(name));
    }
}
