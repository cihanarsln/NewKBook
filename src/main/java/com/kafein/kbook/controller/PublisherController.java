package com.kafein.kbook.controller;

import com.kafein.kbook.dto.PublisherDTO;
import com.kafein.kbook.service.base.PublisherService;
import com.kafein.kbook.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook")
@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(path = "/publishers")
    @ResponseBody
    public List<PublisherDTO> getAll(){
        return publisherService.findAll();
    }

    @PostMapping(path = "/publishers")
    @ResponseBody
    public Publisher save(@RequestBody PublisherDTO publisher){
        return publisherService.save(publisher);
    }

}
