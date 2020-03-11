package com.javatask.taskapp;

import com.javatask.taskapp.model.Person;
import com.javatask.taskapp.model.PersonDocuments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@SpringBootApplication
public class Application {
    /*
    Person {
        username, password, role (admin/person)
    }

        1.	Java proqram dili vasitəsi ilə REST qaydalarına cavab verən APİ yaradılmalıdır.
        2.	Məlumatlara ancaq sistemdə qeydiyyat kemiş şəxslərə  (Persons) baxa bilər (Credits, CreditHistory).
        3.	Məlumatlarda dəyişilik ancaq “role” inzibatçı olan şəxslər tərəfindən həyata keçirilə bilər (Credits, CreditHistory).
        4.	Avtorizasiya token uzerinden olmalıdır.
        5.	Persons və PersonRoles cədvəllərə qeyd məlumatlara(email, password) qeydiyyatdav keçmək mümkün olmalıdır və eyni məlumatlar istifadə olunmaqla avtorizasiya mümkün olmalıdır.
        6.	Ayrı-ayrı cədvəllərlə işləmək üçün yaradılan endpointlərdən əlavə bir kredit haqqında tam məlumatı qaytaran endpoint olmalıdır
        a.	sorğaya cavab olaraq JSON-da kredit(Credits)  məlumatı və həmin kreditin tarixcəsi (CreditHistory) məlumatları olmalıdır.


     */


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }





    @Bean
    public List<Person> getPersons() {
        return new ArrayList<>();
    }

    @Bean
    public List<PersonDocuments> getDocuments() {
        return new ArrayList<>();
    }

    @Bean
    public AtomicInteger idValue() {
        return new AtomicInteger(1);
    }

    @Bean
    public Map<String, Person> authenticatedPersons() {
        return new HashMap<>();
    }

}