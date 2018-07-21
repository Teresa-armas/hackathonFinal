package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.model.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao extends GenericJpaDao<Product> {


    public ProductDao() {
        super(Product.class);
    }
}
