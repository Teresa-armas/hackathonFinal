package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.dao.jpa.ProductDao;
import org.academiadecodigo.hackathon.persistence.model.Customer;
import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductsServiceImpl implements ProductsService {

    private Dao<Product> productDao;

    public List<Product> listProducts() {

        return productDao.findAll();
    }

    @Autowired
    public void setProductDao(Dao<Product> productDao) {
        this.productDao = productDao;
    }
}
