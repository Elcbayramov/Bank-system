package com.javatask.taskapp.repository;

import com.javatask.taskapp.model.CreditHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditHistoryRepository extends CrudRepository<CreditHistory,Integer> {
    List<CreditHistory> findAll();

}
