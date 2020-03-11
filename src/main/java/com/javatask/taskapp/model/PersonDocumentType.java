package com.javatask.taskapp.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "document_type")
public class PersonDocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id",nullable = false)
    private Integer id;

    @Column(name = "type_name",nullable = false)
    private String typeName;

    @Column(name = "document_description",nullable = false)
    private String description;

    @ManyToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "document_id",nullable = false)
    private PersonDocuments documents;





}
