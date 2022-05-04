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
public class EnterpriseCreditCard {
    @Id
    private String id;

    private String idClient;
    private String description;
    private String abbreviation;
    private String isoCurrencyCode;
    private String debitCardNumber;

    private BigDecimal creditCardLine;
    private BigDecimal interesRate;
    private Date paymentDate;
    private Date expirationCardDate;
    private Date cutDate;
    private Date emitionDate;

    private short registrationStatus;
    private Date insertionDate;
    private String fk_insertionUser;
    private String insertionTerminal;
}
