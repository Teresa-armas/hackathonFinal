package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Purchase;

/**
 * Common interface for product services, provides methods to manage accounts and perform product transactions
 */
public interface AccountService {

    /**
     * Gets the product with the given id
     *
     * @param id the product id
     * @return the product
     */
    Purchase get(Integer id);

    /**
     * Adds an product to the service
     *
     * @param account the product to add
     * @return the product id
     */
    Integer add(Purchase account);

    /**
     * Perform an {@link Purchase} deposit
     *
     * @param id     the id of the product
     * @param amount the amount to deposit
     */
    void deposit(Integer id, double amount);

    /**
     * Perform an {@link Purchase} withdrawal
     *
     * @param id     the id of the product
     * @param amount the amount to withdraw
     */
    void withdraw(Integer id, double amount);

    /**
     * Performs a transfer between two {@link Purchase} if possible
     *
     * @param srcId  the source product id
     * @param dstId  the destination product id
     * @param amount the amount to transfer
     */
    void transfer(Integer srcId, Integer dstId, double amount);
}
