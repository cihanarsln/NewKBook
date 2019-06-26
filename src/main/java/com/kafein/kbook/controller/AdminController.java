package com.kafein.kbook.controller;


import com.kafein.kbook.service.base.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/kbook/admins")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

}
