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
public class ContactController { //Fazendo o meu CRUD || Making my CRUD

    @Autowired
    private ContactRepository cRepository;

    @RequestMapping(value="/contacts", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Contact> createC(@RequestBody Contact contact){
        return new ResponseEntity<> (cRepository.save(contact), HttpStatus.OK);
    }

    @RequestMapping(value="/contacts", method = RequestMethod.GET)
    public @ResponseBody
    List<Contact> allContacts(){
        return cRepository.findAll();
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Optional<Contact>> findContact(@PathVariable("id") Long id){
        return new ResponseEntity<>(cRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/contacts", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Contact> updateC(@RequestBody Contact contact) {
        return contact.getId() != null ? new ResponseEntity<>(cRepository.save(contact), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Void> deleteC(@PathVariable("id") Long id){
        try {
            cRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EmptyResultDataAccessException er){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
