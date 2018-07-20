package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Customer;

import java.util.List;
import java.util.Set;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface CustomerService {

    Customer get(Integer id);

}
