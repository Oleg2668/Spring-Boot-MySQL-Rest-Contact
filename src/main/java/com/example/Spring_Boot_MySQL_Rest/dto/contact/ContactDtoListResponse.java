package com.example.Spring_Boot_MySQL_Rest.dto.contact;

import com.example.Spring_Boot_MySQL_Rest.entity.contact.Contact;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public record ContactDtoListResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        List<Contact> contactList) {

    public static final String SUCCESS_MESSAGE = "Contact list has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Contact list has not been found!";

    public static com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoListResponse of(boolean isContactListEmpty, List<Contact> contactList) {
        if (isContactListEmpty)
            return new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoListResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, FAILURE_MESSAGE, Collections.emptyList());
        else
            return new com.example.Spring_Boot_MySQL_Rest.dto.contact.ContactDtoListResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE, contactList);
    }
}
