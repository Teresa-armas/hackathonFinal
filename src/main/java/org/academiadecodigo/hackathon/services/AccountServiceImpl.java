package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.dao.AccountDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * An {@link AccountService} implementation
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    /**
     * Sets the product data access object
     *
     * @param accountDao the product DAO to set
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @see AccountService#get(Integer)
     */
    @Override
    public Purchase get(Integer id) {
        return accountDao.findById(id);
    }

    /**
     * @see AccountService#add(Purchase)
     */
    @Transactional
    @Override
    public Integer add(Purchase account) {
        return accountDao.saveOrUpdate(account).getId();
    }

    /**
     * @see AccountService#deposit(Integer, double)
     */
    @Transactional
    @Override
    public void deposit(Integer id, double amount) {

    }

    /**
     * @see AccountService#withdraw(Integer, double)
     */
    @Transactional
    @Override
    public void withdraw(Integer id, double amount) {

    }

    /**
     * @see AccountService#transfer(Integer, Integer, double)
     */
    @Transactional
    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

    }
}


