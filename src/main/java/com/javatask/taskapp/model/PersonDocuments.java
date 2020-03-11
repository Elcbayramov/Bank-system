package com.javatask.taskapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "documents")
public class PersonDocuments {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Integer id;

    @OneToMany(mappedBy = "documents", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<PersonDocumentType> personDocumentType;

    @Column(name = "document_number",nullable = false)
    private Integer documentNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "document_expire_on",columnDefinition="DATETIME",nullable = false)
    private Date documentExpiredOn;



}
