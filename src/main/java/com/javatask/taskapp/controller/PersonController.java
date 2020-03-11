package com.javatask.taskapp.controller;

import com.javatask.taskapp.model.Person;
import com.javatask.taskapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {



    private PersonService personService;

    @GetMapping("/persons/{username}")
    public Person getUser(@PathVariable String username) {
        return personService.getPerson(username);
    }

    @GetMapping("/persons")
    public List<Person> getUsers(@PathVariable Person person) {
        return personService.getPersons(person);
    }

    @PostMapping
    public void saveUser(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @PutMapping
    public void updateUser(@RequestBody Person person) {
        personService.updatePerson(person);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody Person person) {
        personService.deletePerson(person);
    }

    @Autowired
    public void setUserService(PersonService personService) {
        this.personService = personService;
    }


}
