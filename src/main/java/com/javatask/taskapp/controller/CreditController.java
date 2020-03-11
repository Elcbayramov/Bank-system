package com.javatask.taskapp.controller;

import com.javatask.taskapp.model.Credits;
import com.javatask.taskapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/person/credit")
public class CreditController {


    private CreditService creditService;

    @GetMapping("/{id}")
    public Credits getCredit (@PathVariable Integer id) {
        return creditService.getCredit(id);
    }

    @GetMapping("/credits")
    public List<Credits> getUsers(@PathVariable Credits credits) {
        return creditService.getCredits(credits);
    }

    @PostMapping
    public void saveCredit(@RequestBody Credits credits) {
        creditService.saveCredit(credits);
    }

    @PutMapping
    public void updateCredit(@RequestBody Credits credits) {
        creditService.updateCredit(credits);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Integer id) {
        creditService.deleteCredit(id);
    }

    @Autowired
    public void setCreditService(CreditService creditService) {
        this.creditService = creditService;
    }


}
