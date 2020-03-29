package br.com.mystudy.agendaContatos.rest;

import br.com.mystudy.agendaContatos.model.Contact;
import br.com.mystudy.agendaContatos.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactController { //Fazendo o meu CRUD || Making my CRUD

    @Autowired
    private ContactRepository cRepository;

    @PostMapping(path="/new")
    public @ResponseBody
    ResponseEntity<Contact> createC(@RequestBody Contact contact){
        return new ResponseEntity<> (cRepository.save(contact), HttpStatus.OK);
    }

    @GetMapping(path="/list")
    public @ResponseBody
    List<Contact> allContacts(){
        return cRepository.findAll();
    }

    @GetMapping(path="/list/{id}")
    public @ResponseBody
    ResponseEntity<Optional<Contact>> findContact(@PathVariable("id") Long id){
        return new ResponseEntity<>(cRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(path="/update")
    public @ResponseBody ResponseEntity<Contact> updateC(@RequestBody Contact contact) {
        return contact.getId() != null ? new ResponseEntity<>(cRepository.save(contact), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody ResponseEntity<Void> deleteC(@PathVariable("id") Long id){
        try {
            cRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EmptyResultDataAccessException er){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
