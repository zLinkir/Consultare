package com.consultare.digitalbank.controller;

import com.consultare.digitalbank.dto.customer.CustomerRequestDTO;
import com.consultare.digitalbank.dto.customer.CustomerResponseDTO;
import com.consultare.digitalbank.entity.customer.Customer;
import com.consultare.digitalbank.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(
            @RequestBody @Valid CustomerRequestDTO request) {

        CustomerResponseDTO response = customerService.createCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

