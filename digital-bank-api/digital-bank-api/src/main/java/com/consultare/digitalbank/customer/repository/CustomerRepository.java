package com.consultare.digitalbank.customer.repository;

import com.consultare.digitalbank.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByCpfAndIdNot(String cpf, Long id);
    Optional<Customer> findByCpf(String cpf);
}
