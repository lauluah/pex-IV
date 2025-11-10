package org.example.exceptions;

public class EmployeeNotfoundException extends RuntimeException {
    public EmployeeNotfoundException(String message) {
        super(message);
    }
}
