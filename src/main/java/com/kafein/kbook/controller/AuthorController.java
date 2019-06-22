package com.kafein.kbook.controller;

import com.kafein.kbook.dto.AuthorDTO;
import com.kafein.kbook.service.base.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(path = "/authors")
    @ResponseBody
    public List<AuthorDTO> getAll(){
        return authorService.findAll();
    }

    @PostMapping(path = "/authors")
    @ResponseBody
    public AuthorDTO save(@RequestBody AuthorDTO author){
        return authorService.save(author);
    }

}
