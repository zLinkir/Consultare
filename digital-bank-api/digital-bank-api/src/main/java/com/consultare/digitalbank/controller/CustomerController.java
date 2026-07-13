package com.consultare.digitalbank.controller;

import com.consultare.digitalbank.dto.customer.CustomerRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping("/create")
    public String createCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return "Cliente recebido com sucesso";
    }
}
