package br.com.mystudy.agendaContatos.service;

import br.com.mystudy.agendaContatos.model.Contact;
import br.com.mystudy.agendaContatos.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    public ResponseEntity<Contact> createContact(Contact contact){
        return new ResponseEntity<>(repository.save(contact), HttpStatus.OK);
    }

    public List<Contact> getAllContacts(){
        return repository.findAll();
    }

    public ResponseEntity<Optional<Contact>> getContactById(Long id){
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Contact> changeContact(Contact contact){
        return contact.getId() != null ? new ResponseEntity<>(repository.save(contact), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteContact(Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error to delete contact -> "+e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
