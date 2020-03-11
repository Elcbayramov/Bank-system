package com.javatask.taskapp.repository;

import com.javatask.taskapp.model.Credits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends CrudRepository<Credits, Integer> {
    List<Credits> findAll();
}
