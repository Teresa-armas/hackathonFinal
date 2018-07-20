package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Customer;
import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.dao.CustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }

    public Set<Integer> listProducts(Integer id) {

        Customer customer = customerDao.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        Set<Integer> accountIds = new HashSet<>();
        List<Purchase> accounts = customer.getPurchases();

        for (Purchase account : accounts) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    @Transactional
    public void addCustomer(Customer customer){
        this.customerDao.saveOrUpdate(customer);
    }

}
