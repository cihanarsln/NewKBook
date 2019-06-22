package com.kafein.kbook.controller;

import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<UserDTO> getAll(){
        return userService.findAll();
    }

    @PostMapping("/users")
    @ResponseBody
    public UserDTO save(@RequestBody UserDTO user){
        return userService.save(user);
    }

}
