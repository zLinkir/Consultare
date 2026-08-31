package com.consultare.digitalbank.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "{customer.cpf.required}")
    @Pattern(regexp = "^\\d{11}$", message = "{customer.cpf.invalid}")
    private String cpf;

    @NotBlank(message = "{customer.password.required}")
    private String password;
}
