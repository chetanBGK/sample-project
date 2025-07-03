package com.sample.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {
    private int rollno;


    public ResourceNotFoundException(int  rollno) {
        super(String.format("Student with rollno %d not found", rollno));

        this.rollno = rollno;
    }
}
