package com.strawhats.notesapp.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String resource;
    private String fieldName;
    private String fieldValue;
    private Long fieldId;

    public ResourceNotFoundException(String resource, String fieldName, String fieldValue) {
        super(String.format("%s with %S : %s not found!", resource, fieldName, fieldValue));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resource, String fieldName, Long fieldId) {
        super(String.format("%s with %S : %d not found!", resource, fieldName, fieldId));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldId =fieldId;
    }
}

