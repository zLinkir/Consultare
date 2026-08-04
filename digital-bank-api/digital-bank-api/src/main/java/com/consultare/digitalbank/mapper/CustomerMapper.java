package com.consultare.digitalbank.mapper;

import com.consultare.digitalbank.dto.customer.CustomerRequestDTO;
import com.consultare.digitalbank.dto.customer.CustomerResponseDTO;
import com.consultare.digitalbank.entity.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDTO requestDTO) {
        Customer customer = new Customer();
        customer.setName(requestDTO.getName());
        customer.setCpf(requestDTO.getCpf());
        customer.setBirthDate(requestDTO.getBirthDate());
        return customer;
    }

    public CustomerResponseDTO toResponse(Customer customer) {
        CustomerResponseDTO responseDTO = new CustomerResponseDTO();
        responseDTO.setId(customer.getId());
        responseDTO.setName(customer.getName());
        responseDTO.setCpf(customer.getCpf());
        responseDTO.setBirthDate(customer.getBirthDate());
        return responseDTO;
    }
}
