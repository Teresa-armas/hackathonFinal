package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Customer;
import org.academiadecodigo.hackathon.persistence.model.Recipient;
import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.dao.CustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An {@link CustomerService} implementation
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    /**
     * Sets the customer data access object
     *
     * @param customerDao the product DAO to set
     */
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * @see CustomerService#get(Integer)
     */
    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }

    /**
     * @see CustomerService#getBalance(Integer)
     */
    @Override
    public double getBalance(Integer id) {

        Customer customer = customerDao.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exists");
        }

        List<Purchase> accounts = customer.getAccounts();

        double balance = 0;
        for (Purchase account : accounts) {
        }

        return balance;
    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        Customer customer = customerDao.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        Set<Integer> accountIds = new HashSet<>();
        List<Purchase> accounts = customer.getAccounts();

        for (Purchase account : accounts) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    /**
     * @see CustomerService#listRecipients(Integer)
     */
    @Transactional(readOnly = true)
    @Override
    public List<Recipient> listRecipients(Integer id) {

        Customer customer = customerDao.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exists");
        }

        return new ArrayList<>(customerDao.findById(id).getRecipients());
    }
}
