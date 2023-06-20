package com.company.ecommerce.exception;

public class AmountRequiredException extends RuntimeException {
    public AmountRequiredException(){
        super("Amount is required");
    }
}
