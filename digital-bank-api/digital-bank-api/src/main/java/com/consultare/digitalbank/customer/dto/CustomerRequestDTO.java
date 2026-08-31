package com.consultare.digitalbank.customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "{customer.password.required}")
    @Size(min = 8, max = 64, message = "{customer.password.size}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).+$",
            message = "{customer.password.weak}"
    )
    private String password;
}
