package org.academiadecodigo.hackathon.services;

import org.academiadecodigo.hackathon.persistence.model.product.Product;

import java.util.List;

public interface ProductsService {
    List<Product> listProducts();
}
