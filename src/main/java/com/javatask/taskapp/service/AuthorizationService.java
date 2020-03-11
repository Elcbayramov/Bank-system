package com.javatask.taskapp.service;


import com.javatask.taskapp.model.Person;

public interface AuthorizationService {
    String getToken(Person person);
    boolean isAuthorized(String token);
    Person getAuthorizedUser(String token);
}
