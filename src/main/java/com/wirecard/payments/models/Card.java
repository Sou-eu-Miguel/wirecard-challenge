package com.wirecard.payments.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private Integer id;
    @NotEmpty
    private String holderName;

    @NotEmpty
    @NotNull(message = "Credit card number is required")
    @Size(min = 16, max = 16, message = "Credit card number must 16 digits long")
    @Digits(fraction = 0, integer = 16)
    @CreditCardNumber
    private String number;
    @NotNull
    @FutureOrPresent
    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    @NotNull
    @Size(min = 3, max = 3, message = "CVV card number must 3 digits long")
    private String cvv;
}
