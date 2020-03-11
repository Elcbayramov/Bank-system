package com.javatask.taskapp.service;

import com.javatask.taskapp.model.CreditHistory;

import java.util.List;

public interface CreditHistoryService {

    List<CreditHistory>findAll(CreditHistory history);

    CreditHistory getHistory (Integer id);

    CreditHistory saveHistory(CreditHistory history);

    void deleteHistory(Integer id);

    CreditHistory updateHistory(CreditHistory history);
}
