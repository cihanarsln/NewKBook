package com.kafein.kbook.controller;

import com.kafein.kbook.service.base.BookTypeService;
import com.kafein.kbook.dto.BookTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook/booktypes")
@RestController
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    @GetMapping
    @ResponseBody
    public List<BookTypeDTO> getAll(){
        return bookTypeService.findAll();
    }

    @PostMapping
    @ResponseBody
    public BookTypeDTO save(@RequestBody BookTypeDTO bookType){
        return bookTypeService.save(bookType);
    }

    @PostMapping("/by-name")
    @ResponseBody
    public List<BookTypeDTO> getByName(@RequestParam("name") String name){
        return bookTypeService.findByName(name);
    }



}
