package com.consultare.digitalbank.customer.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException() {
        super("customer.cpf.alreadyExists");
    }

    public String getField() {
        return "cpf";
    }
}
