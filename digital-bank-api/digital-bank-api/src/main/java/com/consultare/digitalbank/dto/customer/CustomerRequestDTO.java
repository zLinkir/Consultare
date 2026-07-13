package com.consultare.digitalbank.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CustomerRequestDTO {

    @NotBlank(message = "{customer.name.required}")
    private String name;

    @NotBlank(message = "{customer.cpf.required}")
    @Pattern(regexp = "^\\d{11}$", message = "{customer.cpf.invalid}")
    private String cpf;

    @NotNull(message = "{customer.birthDate.required}")
    @Past(message = "{customer.birthDate.invalid}")
    private LocalDate birthDate;
}
