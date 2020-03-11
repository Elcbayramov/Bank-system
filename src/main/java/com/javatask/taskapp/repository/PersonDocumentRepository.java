package com.javatask.taskapp.repository;

import com.javatask.taskapp.model.PersonDocuments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDocumentRepository extends CrudRepository <PersonDocuments,Integer> {

}
