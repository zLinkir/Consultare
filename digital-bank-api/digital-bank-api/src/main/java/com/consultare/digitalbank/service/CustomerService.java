package com.consultare.digitalbank.service;

import com.consultare.digitalbank.dto.customer.CustomerRequestDTO;
import com.consultare.digitalbank.dto.customer.CustomerResponseDTO;
import com.consultare.digitalbank.entity.customer.Customer;
import com.consultare.digitalbank.mapper.CustomerMapper;
import com.consultare.digitalbank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    private final CustomerMapper mapper;

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = mapper.toEntity(customerRequestDTO);
        Customer savedCustomer = repository.save(customer);
        return mapper.toResponse(savedCustomer);
    }

}
