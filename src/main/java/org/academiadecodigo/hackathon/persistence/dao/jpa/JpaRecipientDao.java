package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.model.Recipient;
import org.academiadecodigo.hackathon.persistence.dao.RecipientDao;

/**
 * A JPA {@link RecipientDao} implementation
 */
public class JpaRecipientDao extends GenericJpaDao<Recipient> implements RecipientDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaRecipientDao() {
        super(Recipient.class);
    }
}
