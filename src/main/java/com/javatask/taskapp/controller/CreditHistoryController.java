package com.javatask.taskapp.controller;

import com.javatask.taskapp.model.CreditHistory;
import com.javatask.taskapp.model.Credits;
import com.javatask.taskapp.service.CreditHistoryService;
import com.javatask.taskapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "person/history")
public class CreditHistoryController {

    private CreditHistoryService creditHistoryService;


    @GetMapping("/{id}")
    public CreditHistory getHistory (@PathVariable Integer id) {
        return creditHistoryService.getHistory(id);
    }

    @GetMapping("/histories")
    public List<CreditHistory> findAll(@PathVariable Integer history) {
        return (List<CreditHistory>) creditHistoryService.getHistory(history);
    }

    @PostMapping
    public void saveHistory (@RequestBody CreditHistory history) {
        creditHistoryService.saveHistory(history);
    }

    @PutMapping
    public void updateHistory(@RequestBody CreditHistory history) {
        creditHistoryService.updateHistory(history);
    }

    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable Integer id) {
        creditHistoryService.deleteHistory(id);
    }

    @Autowired
    public void setCreditHistoryService(CreditHistoryService creditHistoryService) {
        this.creditHistoryService = creditHistoryService;
    }

}
