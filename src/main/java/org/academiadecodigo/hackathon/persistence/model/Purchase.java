package org.academiadecodigo.hackathon.persistence.model;

import org.academiadecodigo.hackathon.persistence.model.product.Product;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchases")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Purchase extends AbstractModel {

    @ManyToOne
    private Customer customer;

    private int totalPrice;
    private String address;


    @OneToMany(   // propagate changes on customer entity to product entities
            cascade = {CascadeType.ALL},

            // make sure to remove purchases if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on product table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "purchase",

            // fetch purchases from database together with user
            fetch = FetchType.EAGER)
    private Set<Product> map = new HashSet<>();

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

    public void updateProduct(Product product) {
        if(product == null){
            System.out.println("null");
        }

        this.map.add( product);
        updateTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private void updateTotalPrice() {

        int price = 0;
        for (Product p : this.map) {
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
