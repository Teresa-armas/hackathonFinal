package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Customer;

public interface CustomerService {
    Customer get(Integer id);
    Customer addCustomer(Customer customer);
}
