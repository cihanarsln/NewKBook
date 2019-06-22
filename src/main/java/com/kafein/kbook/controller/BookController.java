package com.kafein.kbook.controller;

import com.kafein.kbook.model.Book;
import com.kafein.kbook.service.base.BookService;
import com.kafein.kbook.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @ResponseBody
    public List<BookDTO> getAll(){
        return bookService.findAll();
    }

    @PostMapping
    @ResponseBody
    public BookDTO save(@RequestBody  BookDTO book){
        return bookService.save(book);
    }

    @PostMapping("/by-name")
    @ResponseBody
    public List<BookDTO> getByName(@RequestParam("name") String name){
        return bookService.findAllByName(name);
    }

    @PostMapping("/by-id")
    @ResponseBody
    public BookDTO getById(@RequestParam("id") int id){
        return bookService.findById(id);
    }


    @PostMapping("/by-author-name")
    @ResponseBody
    public List<BookDTO> getAllByAuthor_FnameAndAuthor_Lname(@RequestParam("fname") String fname, @RequestParam("lname") String lname){
        return bookService.findAllByAuthor_FnameAndAuthor_Lname(fname, lname);
    }

    @PostMapping("/by-publisher-name")
    @ResponseBody
    public List<BookDTO> getAllByPublisher_Name(@RequestParam("name") String name){
        return bookService.findAllByPublisher_Name(name);
    }

    @PostMapping("/by-type")
    @ResponseBody
    public List<BookDTO> getAllByType_Name(@RequestParam("name") String name){
        return bookService.findAllByType_Name((name));
    }

}
