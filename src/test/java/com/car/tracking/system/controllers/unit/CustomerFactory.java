package com.car.tracking.system.controllers.unit;

import com.car.tracking.system.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactory {

    public static List<Customer> getCustomer() {
        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();
        customer.setId("d9a4ad55-25c1-42e9-aa11-8c214ce912de");
        customer.setName("Can");
        customer.setSurname("Avar");
        customer.setTelephone("0538 956 48 52");
        customer.setAddress("Bakırköy");
        customers.add(customer);

        return customers;
    }

    public static Customer saveCustomer() {

        Customer customer = new Customer();

        customer.setId("d9a4ad55-25c1-42e9-aa11-8c214ce912de");
        customer.setName("Can");
        customer.setSurname("Avar");
        customer.setTelephone("0538 956 48 52");
        customer.setAddress("Bakırköy");

        return customer;
    }

}
