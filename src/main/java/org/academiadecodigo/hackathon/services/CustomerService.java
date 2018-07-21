package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Customer;

public interface CustomerService {
    Customer get(Integer id);
    void addCustomer(Customer customer);
}
