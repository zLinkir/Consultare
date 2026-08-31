package com.consultare.digitalbank.auth.service;

import com.consultare.digitalbank.auth.dto.LoginRequestDTO;
import com.consultare.digitalbank.auth.exception.InvalidCredentialsException;
import com.consultare.digitalbank.customer.dto.CustomerResponseDTO;
import com.consultare.digitalbank.customer.entity.Customer;
import com.consultare.digitalbank.customer.mapper.CustomerMapper;
import com.consultare.digitalbank.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final PasswordEncoder passwordEncoder;

    public CustomerResponseDTO login(LoginRequestDTO request) {
        Customer customer = customerRepository.findByCpf(request.getCpf())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(request.getPassword(), customer.getPasswordHash())) {
            throw new InvalidCredentialsException();
        }

        return customerMapper.toResponse(customer);
    }
}
