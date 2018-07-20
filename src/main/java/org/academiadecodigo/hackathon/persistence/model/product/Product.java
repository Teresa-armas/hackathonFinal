package org.academiadecodigo.hackathon.persistence.model.product;

import org.academiadecodigo.hackathon.persistence.model.AbstractModel;
import org.academiadecodigo.hackathon.persistence.model.Purchase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends AbstractModel {

    @ManyToOne
    private Purchase purchase;


    private String productName;
    private int price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
