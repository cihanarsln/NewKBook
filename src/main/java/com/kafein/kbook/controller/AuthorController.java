package com.kafein.kbook.controller;

import com.kafein.kbook.dto.AuthorDTO;
import com.kafein.kbook.service.base.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook/authors")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    @ResponseBody
    public List<AuthorDTO> getAll(){
        return authorService.findAll();
    }

    @PostMapping
    @ResponseBody
    public AuthorDTO save(@RequestBody AuthorDTO author){
        return authorService.save(author);
    }

    @PostMapping("/by-id")
    @ResponseBody
    public AuthorDTO findById(@RequestParam ("id") int id){
        return authorService.findById(id);
    }

    @PostMapping("/by-fname")
    @ResponseBody
    public List<AuthorDTO> findAllByFname(@RequestParam ("fname") String fname){
        return authorService.findAllByFname(fname);
    }

    @PostMapping("/by-lname")
    @ResponseBody
    public List<AuthorDTO> findAllByLname(@RequestParam ("fname") String lname){
        return authorService.findAllByLname(lname);
    }

    @PostMapping("/by-fnameandlname")
    @ResponseBody
    public List<AuthorDTO> findAllByFnameAndLname(@RequestParam("fname") String fname, @RequestParam ("lname") String lname){
        return authorService.findAllByFnameAndLname(fname, lname);
    }

}
