package com.example.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name should have at least 3 characters")
    @Pattern(regexp = "[A-Z][a-z]*", message = "Name should start with an uppercase letter")
    private String name;

    @Size(min = 3, message = "Name should have at least 3 characters")
    @NotBlank(message = "Surname is mandatory")
    @Pattern(regexp = "[A-Z][a-z]*(-[A-Z][a-z]*)?", message = "Surname should start with an uppercase letter")
    private String surname;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    private double totalPrice;

    @PreUpdate
    @PrePersist
    private void updatePrice() {
        totalPrice = tickets.stream().mapToDouble(Ticket::getPrice).sum();
    }

}
