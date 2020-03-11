package com.javatask.taskapp.service.serviceImpl;


import com.javatask.taskapp.model.Person;
import com.javatask.taskapp.service.AuthorizationService;
import com.javatask.taskapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private Map<String, Person> authenticatedPersons;

    @Autowired
    private PersonService personService;

    @Override
    public String getToken(Person person) {
        Person search = personService.getPerson(person.getFullName());
        if(Objects.nonNull(search)
                && Objects.equals(search.getPassword(), person.getPassword()))  {
            String key = UUID.randomUUID().toString();
            authenticatedPersons.put(key, search);
            return key;
        }
        return "";
    }

    @Override
    public boolean isAuthorized(String token) {
        return authenticatedPersons.containsKey(token);
    }

    @Override
    public Person getAuthorizedUser(String token) {
        return authenticatedPersons.get(token);
    }
}
