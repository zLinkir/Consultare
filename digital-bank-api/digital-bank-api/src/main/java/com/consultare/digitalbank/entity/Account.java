package com.consultare.digitalbank.entity;

import com.consultare.digitalbank.entity.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private Long accountNumber;

    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    @ManyToOne
    private Customer customer;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private AccountStatus status;
}
