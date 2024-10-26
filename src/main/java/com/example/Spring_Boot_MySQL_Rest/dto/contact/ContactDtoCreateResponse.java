package com.example.Spring_Boot_MySQL_Rest.dto.contact;

import com.example.Spring_Boot_MySQL_Rest.entity.contact.Contact;
import org.springframework.http.HttpStatus;

public record ContactDtoCreateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Contact contact) {

    public static final String SUCCESS_MESSAGE = "Contact has been created successfully.";
    public static final String FAILURE_MESSAGE = "Contact has not been created!";

    public static com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoCreateResponse of(boolean isContactCreated, Contact contact) {
        // ternary operator usage
        return (isContactCreated) ?
                new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoCreateResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        true, SUCCESS_MESSAGE, contact) :
                new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoCreateResponse(
                        HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.getReasonPhrase(),
                        false, FAILURE_MESSAGE, null);
    }
}

