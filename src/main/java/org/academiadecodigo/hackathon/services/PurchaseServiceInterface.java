package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.model.product.Product;

/**
 * Common interface for product services, provides methods to manage accounts and perform product transactions
 */
public interface PurchaseServiceInterface {

    Purchase get(Integer id);

    Integer add(Purchase account);

    void updateProduct(Integer purchaseId, Product product, int quantity);

}
