package com.javatask.taskapp.service;

import com.javatask.taskapp.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface PersonService {

    List<Person> getPersons(Person person);

    Person getPerson(String username);

    void savePerson(Person user);

    void deletePerson(Person user);

    void updatePerson(Person user);
}
