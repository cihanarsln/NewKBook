package com.kafein.kbook.controller;

import com.kafein.kbook.dto.RoleDTO;
import com.kafein.kbook.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kbook/roles")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    @ResponseBody
    public RoleDTO save(@RequestBody RoleDTO role){return roleService.save(role);}

    @GetMapping
    @ResponseBody
    public List<RoleDTO> findAll(){return roleService.findAll();}

    @PostMapping("/by-role")
    @ResponseBody
    public RoleDTO finByRole(@RequestParam("role") String role){
        return roleService.findByRole(role);
    }

}
