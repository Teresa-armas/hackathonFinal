package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.model.Purchase;

/**
 * A JPA {@link org.academiadecodigo.hackathon.persistence.dao.PurchaseDao} implementation
 */
public class PurchaseDao extends GenericJpaDao<Purchase> implements org.academiadecodigo.hackathon.persistence.dao.PurchaseDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public PurchaseDao() {
        super(Purchase.class);
    }
}
