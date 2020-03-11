package com.javatask.taskapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "credits_type")
public class CreditType {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "credit_type_id", nullable = false)
    private Integer creditTypeId;

    @Column(name = "credit_type_name" ,nullable = false)
    private String creditTypeName;

    @Column(name = "credit_type_description")
    private String creditTypeDescription;

    @OneToOne(mappedBy = "creditType")
    private Credits credits;

}
