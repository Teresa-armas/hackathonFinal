package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends AbstractModel {

    private String name;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    private String creditCard;
    private String email;
    private String phone;

    @OneToMany(
            // propagate changes on customer entity to product entities
            cascade = {CascadeType.ALL},

            // make sure to remove purchases if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on product table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer",

            // fetch purchases from database together with user
            fetch = FetchType.EAGER
    )
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(
            // propagate changes on customer entity to product entities
            cascade = {CascadeType.ALL},

            // make sure to remove recipients if unlinked from customer
            orphanRemoval = true,

            // use recipient foreign key on recipient table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer"
    )

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<Purchase> getPurchases() {
        return purchases;
    }



    public void addAccount(Purchase account) {
        purchases.add(account);
        account.setCustomer(this);
    }

    public void removeAccount(Purchase account) {
        purchases.remove(account);
        account.setCustomer(null);
    }



    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + name+ '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", purchases=" + purchases +
                "} " + super.toString();
    }
}



