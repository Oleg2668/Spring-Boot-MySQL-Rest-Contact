package com.example.Spring_Boot_MySQL_Rest.dto.contact;

import com.example.Spring_Boot_MySQL_Rest.entity.contact.Contact;
import org.springframework.http.HttpStatus;

public record ContactDtoUpdateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Contact contact) {

    public static final String SUCCESS_MESSAGE = "Contact with id %s has been updated successfully.";
    public static final String FAILURE_MESSAGE = "Contact with id %s has not been found!";

    public static com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoUpdateResponse of(Long id, boolean isContactFound, Contact contactUpdated) {
        if (isContactFound)
            return new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoUpdateResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(id), contactUpdated);
        else
            return new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoUpdateResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, FAILURE_MESSAGE.formatted(id), null);
    }
}

