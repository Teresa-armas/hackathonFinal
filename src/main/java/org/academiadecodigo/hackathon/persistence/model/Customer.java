package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer model entity
 */
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
    private List<Recipient> recipients = new ArrayList<>();

    /**
     * Gets the first name of the customer
     *
     * @return the customer last name
     */
    public String getName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone of the customer
     *
     * @return the customer phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone of the customer
     *
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the customer accounts
     *
     * @return the accounts
     */
    public List<Purchase> getAccounts() {
        return accounts;
    }

    /**
     * Gets the customer recipients
     *
     * @return the recipients
     */
    public List<Recipient> getRecipients() {
        return recipients;
    }

    /**
     * Adds a new product to the customer
     *
     * @param account the product to add
     */
    public void addAccount(Purchase account) {
        accounts.add(account);
        account.setCustomer(this);
    }

    /**
     * Removes an product from the customer
     *
     * @param account the product to remove
     */
    public void removeAccount(Purchase account) {
        accounts.remove(account);
        account.setCustomer(null);
    }

    /**
     * Adds a new recipient to the customer
     *
     * @param recipient the recipient to add
     */
    public void addRecipient(Recipient recipient) {
        recipients.add(recipient);
        recipient.setCustomer(this);
    }

    /**
     * Removes a recipient from the customer
     *
     * @param recipient the recipient to remove
     */
    public void removeRecipient(Recipient recipient) {
        recipients.remove(recipient);
        recipient.setCustomer(null);
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
                ", recipients=" + recipients +
                "} " + super.toString();
    }
}



