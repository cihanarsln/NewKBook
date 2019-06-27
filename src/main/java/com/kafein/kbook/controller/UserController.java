package com.kafein.kbook.controller;

import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public List<UserDTO> getAll(){
        return userService.findAll();
    }

    @PostMapping
    @ResponseBody
    public UserDTO save(@RequestBody UserDTO user){
        return userService.save(user);
    }

}
