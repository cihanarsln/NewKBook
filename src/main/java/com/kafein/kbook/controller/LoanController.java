package com.kafein.kbook.controller;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.model.Loan;
import com.kafein.kbook.service.base.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;

@RequestMapping("/kbook/loans")
@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    @ResponseBody
    public List<LoanDTO> getAll(){
        return loanService.findAll();
    }

    @PostMapping
    @ResponseBody
    public Loan save(@RequestBody LoanDTO loanDTO ){
        return loanService.save(loanDTO);
    }

}
