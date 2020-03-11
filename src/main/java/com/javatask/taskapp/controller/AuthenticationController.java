package com.javatask.taskapp.controller;


import com.javatask.taskapp.model.Person;
import com.javatask.taskapp.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping
public class AuthenticationController {

    @Autowired
    AuthorizationService authorizationService;


    @GetMapping("/person")
    public ResponseEntity<?> Person (@RequestBody Person person) {
        return ResponseEntity.ok(authorizationService.getToken(person));
    }

    @PutMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestHeader HttpHeaders httpHeaders) {
        String key = "";
        List<String> token = httpHeaders.get("token");
        if (token != null && token.size() > 0) {
            key = token.get(0);
        }
        Person person = authorizationService.getAuthorizedUser(key);
        if (Objects.nonNull(person)) {
            String res = "Hello, " + person.getFullName();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(res);//200 OK other style
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();//HTTP STATUS 401
    }
}