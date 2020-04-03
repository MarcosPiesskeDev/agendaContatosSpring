package br.com.mystudy.agendaContatos.controller;

import br.com.mystudy.agendaContatos.model.Contact;
import br.com.mystudy.agendaContatos.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController { //Fazendo o meu CRUD || Making my CRUD

    @Autowired
    private ContactService service;

    @RequestMapping(value="/contacts", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity createC(@RequestBody Contact c){
        return ResponseEntity.ok(service.createContact(c));
    }

    @RequestMapping(value="/contacts", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity allContacts(){
        return ResponseEntity.ok(service.getAllContacts());
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity findContact(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getContactById(id));
    }

    @RequestMapping(value="/contacts", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity updateC(@RequestBody Contact c) {
        return ResponseEntity.ok(service.changeContact(c));
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteC(@PathVariable("id") Long id){
       return ResponseEntity.ok(service.deleteContact(id));
    }
}
