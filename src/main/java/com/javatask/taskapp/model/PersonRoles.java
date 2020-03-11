package com.javatask.taskapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "person_roles")
public class PersonRoles  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id" ,nullable = false)
    private Integer id;

    @Column(name = "role_name" ,nullable = false)
    private String role;

    @ManyToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;



}
