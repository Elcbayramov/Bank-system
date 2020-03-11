package com.javatask.taskapp.repository;

import com.javatask.taskapp.model.CreditType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepository extends CrudRepository<CreditType,Integer> {
}
