package com.contactbook.controller;

import com.contactbook.entity.Customer;
import com.contactbook.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
@Api(value = "API Rest for Customer Management")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert customer in table customer")
    public Customer save(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Return a customer list")
    public List<Customer> list() {
        return repository.findAll();
    }

    @GetMapping(value = "/find/{id}")
    @ApiOperation(value = "Find customer by ID")
    @ResponseStatus(HttpStatus.OK)
    public Customer findCustomerById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.findById(id)
                .map(customer -> {
                    repository.delete(customer);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }


    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Customer customerUpdated){
        repository.findById(id).map(customer -> {
            customerUpdated.setIdCustomer(customer.getIdCustomer());
            return repository.save(customerUpdated);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não Encontrado"));

    }
}