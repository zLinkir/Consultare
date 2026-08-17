package com.consultare.digitalbank.customer.service;

import com.consultare.digitalbank.customer.dto.CustomerRequestDTO;
import com.consultare.digitalbank.customer.dto.CustomerResponseDTO;
import com.consultare.digitalbank.customer.dto.CustomerUpdateRequestDTO;
import com.consultare.digitalbank.customer.entity.Customer;
import com.consultare.digitalbank.customer.exception.CustomerAlreadyExistsException;
import com.consultare.digitalbank.customer.exception.CustomerNotFoundException;
import com.consultare.digitalbank.customer.mapper.CustomerMapper;
import com.consultare.digitalbank.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    private final CustomerMapper mapper;

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        if (repository.existsByCpf(customerRequestDTO.getCpf())) {
            throw new CustomerAlreadyExistsException();
        }
        Customer customer = mapper.toEntity(customerRequestDTO);
        Customer savedCustomer = repository.save(customer);
        return mapper.toResponse(savedCustomer);
    }

    public CustomerResponseDTO findCustomerById(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);
        return mapper.toResponse(customer);
    }

    public List<CustomerResponseDTO> findAllCustomers() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public CustomerResponseDTO updateCustomer(Long id, CustomerUpdateRequestDTO customerRequestDTO) {
        Customer existingCustomer = repository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        if (repository.existsByCpfAndIdNot(customerRequestDTO.getCpf(), id)) {
            throw new CustomerAlreadyExistsException();
        }

        if (customerRequestDTO.getName() != null) {
            existingCustomer.setName(customerRequestDTO.getName());
        }
        if (customerRequestDTO.getCpf() != null) {
            existingCustomer.setCpf(customerRequestDTO.getCpf());
        }
        if (customerRequestDTO.getBirthDate() != null) {
            existingCustomer.setBirthDate(customerRequestDTO.getBirthDate());
        }
        Customer updatedCustomer = repository.save(existingCustomer);
        return mapper.toResponse(updatedCustomer);
    }

}
