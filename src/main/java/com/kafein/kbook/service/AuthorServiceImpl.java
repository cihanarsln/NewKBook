package com.kafein.kbook.service;

import com.kafein.kbook.dto.AuthorDTO;
import com.kafein.kbook.mapper.AuthorMapper;
import com.kafein.kbook.service.base.AuthorService;
import com.kafein.kbook.model.Author;
import com.kafein.kbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public Author save(AuthorDTO authorDTO) {
        return authorRepository.save(authorMapper.toAuthor(authorDTO));
    }

    @Override
    public List<AuthorDTO> findAll() {
        return authorMapper.toAuthorDTOList(authorRepository.findAll());
    }

}
