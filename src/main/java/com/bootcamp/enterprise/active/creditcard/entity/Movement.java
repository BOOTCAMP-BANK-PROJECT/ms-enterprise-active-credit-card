package com.bootcamp.enterprise.active.creditcard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Movement {

    @Id
    private String id;
    private BigDecimal amount;
    private String idDepartureAccount;
    private String idIncomeAccount;
    private Date transactionDate;
    private String isoCurrencyCode;
    private String originMovement;
    private String descriptionMovement;
    private Boolean isPassive;
    private Date insertionDate;
    private String fk_insertionUser;
    private String insertionTerminal;
    private short registrationStatus;
}
