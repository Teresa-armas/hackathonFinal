package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.dao.PurchaseDao;
import org.academiadecodigo.hackathon.persistence.model.product.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * An {@link PurchaseServiceInterface} implementation
 */
public class PurchaseService implements PurchaseServiceInterface {

    private PurchaseDao purchaseDao;

    public void setPurchaseDao(PurchaseDao accountDao) {
        this.purchaseDao = accountDao;
    }

    @Override
    public Purchase get(Integer id) {
        return purchaseDao.findById(id);
    }

    @Transactional
    @Override
    public Integer add(Purchase account) {
        return purchaseDao.saveOrUpdate(account).getId();
    }

    @Transactional
    @Override
    public void updateProduct(Integer purchaseId, Product product, int quantity) {

        Purchase purchase = purchaseDao.findById(purchaseId);
        purchase.updateProduct(product,quantity);
    }

}


