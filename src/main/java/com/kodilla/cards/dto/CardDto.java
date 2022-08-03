package com.kodilla.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private Long customerId;
    private String number;
    private LocalDate expirationDate;
    private String securityCode;
}
