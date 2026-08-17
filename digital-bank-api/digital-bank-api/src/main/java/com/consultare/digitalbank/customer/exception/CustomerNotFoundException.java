package com.consultare.digitalbank.customer.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("customer.id.notFound");
    }

    public String getField() {
        return "id";
    }
}
