package com.kafein.kbook.controller;


import com.kafein.kbook.dto.AdminDTO;
import com.kafein.kbook.service.base.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook/admins")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    @ResponseBody
    public List<AdminDTO> findAll(){
        return adminService.findAll();
    }

    @PostMapping
    @ResponseBody
    public AdminDTO save(@RequestBody AdminDTO admin){
        return adminService.save(admin);
    }

    @DeleteMapping("/delete-by-id")
    @ResponseBody
    public void deleteById(@RequestParam("id") int id){
        adminService.deleteById(id);
    }

}
