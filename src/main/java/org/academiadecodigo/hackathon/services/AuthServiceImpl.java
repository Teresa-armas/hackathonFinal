package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * An {@link AuthService} implementation
 */
public class AuthServiceImpl implements AuthService {

    private Integer accessingCustomerId;
    private CustomerService customerService;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * @see AuthService#authenticate(Integer)
     */
    @Override
    public boolean authenticate(Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return false;
        }

        accessingCustomerId = customer.getId();
        return true;
    }

    /**
     * @see AuthService#getAccessingCustomer()
     */
    @Override
    public Customer getAccessingCustomer() {
        return customerService.get(accessingCustomerId);
    }
}
