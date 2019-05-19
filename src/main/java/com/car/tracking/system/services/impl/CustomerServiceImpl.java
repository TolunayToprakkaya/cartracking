package com.car.tracking.system.services.impl;

import com.car.tracking.system.models.Customer;
import com.car.tracking.system.repostories.CustomerRepository;
import com.car.tracking.system.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findOneById(String id) {
        return this.customerRepository.findById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Transactional
    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

}
