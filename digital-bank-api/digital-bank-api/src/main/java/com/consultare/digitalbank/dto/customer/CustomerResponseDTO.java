package com.consultare.digitalbank.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {

    private Long id;

    private String name;

    private String cpf;

    private LocalDate birthDate;
}