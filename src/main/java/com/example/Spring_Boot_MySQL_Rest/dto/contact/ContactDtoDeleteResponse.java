package com.example.Spring_Boot_MySQL_Rest.dto.contact;

import org.springframework.http.HttpStatus;

public record ContactDtoDeleteResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message) {

    public static final String SUCCESS_MESSAGE = "Contact with id %s has been deleted successfully.";
    public static final String FAILURE_MESSAGE = "Contact with id %s has not been found!";

    public static com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoDeleteResponse of(Long id, boolean isContactFound) {
        if (isContactFound)
            return new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoDeleteResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(id));
        else
            return new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoDeleteResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, FAILURE_MESSAGE.formatted(id));
    }
}
