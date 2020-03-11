package com.javatask.taskapp.service.serviceImpl;

import com.javatask.taskapp.model.Credits;
import com.javatask.taskapp.model.Person;
import com.javatask.taskapp.repository.PersonRepository;
import com.javatask.taskapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class PersonServiceImpl implements PersonService {

    private List<Person> persons;

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> getPersons(Person person) {
        Integer persons = person.getId();
        List<Person> personList = personRepository.findAll().stream()
                .filter(cr -> persons.equals(cr.getFullName()))
                .collect(Collectors.toList());

        return personList;
    }

    @Override
    public Person getPerson(String username) {
        return persons.stream()
                .filter(u -> Objects.equals(username, u.getFullName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void savePerson(Person person) {
        if(checkExist(person.getFullName()))
            return;

        personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        persons.removeIf(u ->
                Objects.equals(person.getFullName(), u.getFullName())
                        && Objects.equals(person.getPassword(), u.getPassword())
                        && Objects.equals(person.getEmail(), u.getEmail())
        );
    }

    @Override
    public void updatePerson(Person person) {
        for (Person u : persons) {
            if (Objects.equals(person.getFullName(), u.getFullName())) {
                u.setPassword(person.getPassword());
                u.setEmail(person.getEmail());
            }
        }
        personRepository.save(person);
    }

    private boolean checkExist(String username) {



        return persons
                .stream()
                .anyMatch(u -> Objects.equals(username, u.getFullName()));
    }

    @Autowired
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
