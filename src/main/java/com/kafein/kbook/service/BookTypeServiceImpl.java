package com.kafein.kbook.service;

import com.kafein.kbook.service.base.BookTypeService;
import com.kafein.kbook.dto.BookTypeDTO;
import com.kafein.kbook.mapper.BookTypeMapper;
import com.kafein.kbook.repository.BookTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeRepository bookTypeRepository;

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public BookTypeDTO save(BookTypeDTO bookTypeDTO) {
        return bookTypeMapper.toBookTypeDTO(bookTypeRepository.save(bookTypeMapper.toBookType(bookTypeDTO)));
    }

    @Override
    public List<BookTypeDTO> findAll() {
        //List<BookType> bookTypes = bookTypeRepository.findAll();
        return bookTypeMapper.toBookTypeDTOList(bookTypeRepository.findAll());
    }

    @Override
    public List<BookTypeDTO> findByName(String name) {
        return bookTypeMapper.toBookTypeDTOList(bookTypeRepository.findByName(name));
    }
}
