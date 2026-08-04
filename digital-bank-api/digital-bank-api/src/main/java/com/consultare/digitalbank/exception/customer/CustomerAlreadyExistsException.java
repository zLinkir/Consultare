package com.consultare.digitalbank.exception.customer;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException() {
        super("customer.cpf.alreadyExists");
    }
}
