package com.example.Spring_Boot_MySQL_Rest.repository;


import com.example.Spring_Boot_MySQL_Rest.entity.contact.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}

