package com.javatask.taskapp.service;

import com.javatask.taskapp.model.Credits;

import java.util.List;

public interface CreditService {
    List<Credits> getCredits(Credits credits);

    Credits getCredit(Integer id);

    Credits saveCredit(Credits credit);

    void deleteCredit(Integer id);

    Credits updateCredit(Credits credit);
}
