package com.javatask.taskapp.repository;

import com.javatask.taskapp.model.PersonRoles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends CrudRepository<PersonRoles,Integer> {

}
