package com.example.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Name should have at least 3 characters")
    @Pattern(regexp = "[A-Z][a-z]*", message = "Name should start with an uppercase letter")
    private String name;

    @Size(min = 3, message = "Name should have at least 3 characters")
    @Pattern(regexp = "[A-Z][a-z]*(-[A-Z][a-z]*)?",
            message = "Surname should start with an uppercase letter, and can consist of two parts separated with a\n" +
                    "single dash")
    private String surname;

    @NotEmpty
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    private LocalDateTime expirationTime;

    @NotNull
    private Boolean isPaid;

}
