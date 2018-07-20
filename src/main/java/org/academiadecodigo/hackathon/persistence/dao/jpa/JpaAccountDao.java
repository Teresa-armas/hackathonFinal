package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.dao.AccountDao;

/**
 * A JPA {@link AccountDao} implementation
 */
public class JpaAccountDao extends GenericJpaDao<Purchase> implements AccountDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaAccountDao() {
        super(Purchase.class);
    }
}
