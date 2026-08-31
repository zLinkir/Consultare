package com.consultare.digitalbank.customer.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateRequestDTO {
    @Pattern(regexp = "^(?!\\s*$).+", message = "{customer.name.invalid}")
    private String name;
    @Pattern(regexp = "^\\d{11}$", message = "{customer.cpf.invalid}")
    private String cpf;
    @Past(message = "{customer.birthDate.invalid}")
    private LocalDate birthDate;
}
