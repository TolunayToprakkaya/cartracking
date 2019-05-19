package com.car.tracking.system.controllers;

import com.car.tracking.system.models.Customer;
import com.car.tracking.system.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    @Qualifier("customerService")
    private CustomerService customerService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    //View
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Customer> view(@PathVariable String id) {
        return customerService.findOneById(id);
    }

    //Save
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    //Update
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }

}
