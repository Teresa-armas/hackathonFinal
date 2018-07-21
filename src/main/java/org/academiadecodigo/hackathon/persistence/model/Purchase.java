package org.academiadecodigo.hackathon.persistence.model;

import org.academiadecodigo.hackathon.persistence.model.product.Product;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name = "purchases")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public class Purchase extends AbstractModel {

    @ManyToOne
    private Customer customer;

    private int totalPrice;
    private String address;

    @MapKey(name = "product_id")
    private HashMap<Product, Integer> map;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "} " + super.toString();
    }

    public void updateProduct(Product product, int quantity) {

        if (quantity == 0) {
            if (this.map.containsKey(product)) {
                this.map.remove(product);
                updateTotalPrice();
            }
            return;
        }

        this.map.put(product, quantity);
        updateTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private void updateTotalPrice() {

        int price = 0;
        for (Product p : this.map.keySet()) {
            price += p.getPrice();
        }

        this.totalPrice = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    public void deleteAllProducts(){
        map.clear();
    }
}
