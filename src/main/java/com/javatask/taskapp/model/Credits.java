package com.javatask.taskapp.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "credits")
public class Credits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Integer creditId;

    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id" , nullable = false)
    private Person person;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "initial_amount", precision = 18,scale = 4,nullable = false)
    private BigDecimal initialAmount;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_type", nullable = false)
    private CreditType creditType;

    @Column(name = "outstanding_debt",precision = 18,scale = 4, nullable = false)
    private Double outstandingDebt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_payment" , columnDefinition="DATETIME",nullable = false)
    private Date lastPayment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "contract_started_on",columnDefinition="DATETIME",nullable = false)
    private Date contractStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "contract_due_on",columnDefinition="DATETIME",nullable = false)
    private Date contractDue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on",columnDefinition="DATETIME",nullable = false)
    private Date createdOn;

    @OneToMany(mappedBy = "credits")
    private List<CreditHistory> creditHistories;



}
