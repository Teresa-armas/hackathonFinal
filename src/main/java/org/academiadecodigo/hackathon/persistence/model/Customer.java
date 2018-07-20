package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends AbstractModel {

    private String name;
    private String creditCard;
    private String email;
    private String phone;

    @OneToMany(
            // propagate changes on customer entity to product entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on product table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private List<Purchase> accounts = new ArrayList<>();

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


    public List<Purchase> getAccounts() {
        return accounts;
    }



    public void addAccount(Purchase account) {
        accounts.add(account);
        account.setCustomer(this);
    }

    public void removeAccount(Purchase account) {
        accounts.remove(account);
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
                ", accounts=" + accounts +
                "} " + super.toString();
    }
}



