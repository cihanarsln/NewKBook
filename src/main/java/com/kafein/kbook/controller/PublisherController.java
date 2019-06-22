package com.kafein.kbook.controller;

import com.kafein.kbook.dto.PublisherDTO;
import com.kafein.kbook.service.base.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook/publishers")
@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    @ResponseBody
    public List<PublisherDTO> getAll(){
        return publisherService.findAll();
    }

    @PostMapping
    @ResponseBody
    public PublisherDTO save(@RequestBody PublisherDTO publisher){
        return publisherService.save(publisher);
    }

}
