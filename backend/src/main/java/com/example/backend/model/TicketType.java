package com.example.backend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@RequiredArgsConstructor
@Getter
public enum TicketType {
    ADULT(new BigDecimal("25.00")),
    CHILD(new BigDecimal("18.00")),
    STUDENT(new BigDecimal("12.50"));

    private final BigDecimal ticketPrice;
}
