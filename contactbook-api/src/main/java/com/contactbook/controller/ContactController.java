package com.contactbook.controller;

import com.contactbook.entity.Contact;
import com.contactbook.repository.ContactRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contact")
@Api(value = "API Rest for Contacts Management")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert contact in table contact")
    public Contact save(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Return a contact list")
    public List<Contact> list() {
        return repository.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a contact from the table")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a contact from the table")
    public Contact update(@RequestBody Contact contact) {
        return repository.save(contact);
    }
}