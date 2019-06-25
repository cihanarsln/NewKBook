package com.kafein.kbook.service;

import com.kafein.kbook.dto.AuthorDTO;
import com.kafein.kbook.mapper.AuthorMapper;
import com.kafein.kbook.service.base.AuthorService;
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
    public AuthorDTO save(AuthorDTO authorDTO) {
        return authorMapper.toAuthorDTO(authorRepository.save(authorMapper.toAuthor(authorDTO)));
    }

    @Override
    public List<AuthorDTO> findAll() {
        return authorMapper.toAuthorDTOList(authorRepository.findAll());
    }

    @Override
    public AuthorDTO findById(int id) {
        return authorMapper.toAuthorDTO(authorRepository.findById(id));
    }

    @Override
    public List<AuthorDTO> findAllByFname(String fname) {
        return authorMapper.toAuthorDTOList(authorRepository.findAllByFname(fname));
    }

    @Override
    public List<AuthorDTO> findAllByLname(String lname) {
        return authorMapper.toAuthorDTOList(authorRepository.findAllByLname(lname));
    }

    @Override
    public List<AuthorDTO> findAllByFnameAndLname(String fname, String lname) {
        return authorMapper.toAuthorDTOList(authorRepository.findAllByFnameAndLname(fname, lname));
    }

}
