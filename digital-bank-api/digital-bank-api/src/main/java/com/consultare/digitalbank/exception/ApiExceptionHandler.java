package com.consultare.digitalbank.exception;

import com.consultare.digitalbank.exception.customer.CustomerAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final MessageSource messageSource;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {

            String field = error.getField();

            String messageKey = error.getDefaultMessage().replace("{", "").replace("}", "");

            errors.put(field, messageKey);

        }

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_ERROR",
                messageSource.getMessage(
                        "exceptions.validation",
                        null,
                        LocaleContextHolder.getLocale()),
                request.getDescription(false).replace("uri=", ""),
                errors
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex, WebRequest request) {
        Map<String, String> fields = new HashMap<>();
        fields.put(
                ex.getField(),
                messageSource.getMessage(
                        ex.getMessage(),
                        null,
                        LocaleContextHolder.getLocale()
                )
        );

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "CUSTOMER_ALREADY_EXISTS",
                messageSource.getMessage(
                        ex.getMessage(),
                        null,
                        LocaleContextHolder.getLocale()),
                request.getDescription(false).replace("uri=", ""),
                fields
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

}
