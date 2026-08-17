package com.consultare.digitalbank.customer.controller;

import com.consultare.digitalbank.customer.dto.CustomerRequestDTO;
import com.consultare.digitalbank.customer.dto.CustomerResponseDTO;
import com.consultare.digitalbank.customer.dto.CustomerUpdateRequestDTO;
import com.consultare.digitalbank.customer.entity.Customer;
import com.consultare.digitalbank.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findCustomerById(@PathVariable Long id) {
        CustomerResponseDTO response = customerService.findCustomerById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAllCustomers() {
        List<CustomerResponseDTO> response = customerService.findAllCustomers();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable Long id,
            @RequestBody @Valid CustomerUpdateRequestDTO request) {

        CustomerResponseDTO response = customerService.updateCustomer(id, request);

        return ResponseEntity.ok(response);
    }

}