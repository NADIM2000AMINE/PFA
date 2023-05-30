package com.pfa.exception;

public class AuditeurNotFoundException extends RuntimeException{
    public AuditeurNotFoundException(Integer id){
        super("Could not found the user with id "+ id);
    }
}
