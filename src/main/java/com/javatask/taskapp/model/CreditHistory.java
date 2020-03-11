package com.javatask.taskapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "credit_history")
public class CreditHistory {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer historyId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_id")
    private Credits credits;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "report_period", columnDefinition="DATETIME")
    private Date reportPeriod;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_type_id")
    private CreditType credittype;



}
