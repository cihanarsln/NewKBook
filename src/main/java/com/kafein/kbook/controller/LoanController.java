package com.kafein.kbook.controller;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.service.base.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public LoanDTO save(@RequestBody LoanDTO loanDTO ){
        return loanService.save(loanDTO);
    }

    @PostMapping("/delete-by-id")
    @ResponseBody
    public void deleteAllById(@RequestParam("id") int id){
        loanService.deleteAllById(id);
    }

    @PostMapping("/by-id")
    @ResponseBody
    public LoanDTO finAllById(@RequestParam("id") int id){
        return loanService.findById(id);
    }

    @PostMapping("/by-user-id")
    @ResponseBody
    public List<LoanDTO> findAllByUser_Id(@RequestParam("id") String id) { return loanService.findAllByUser_Id(id);}

    @PostMapping("/delivery")
    @ResponseBody
    public LoanDTO deliver(@RequestParam("id") int id){return loanService.deliver(id);}

}
