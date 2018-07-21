package org.academiadecodigo.hackathon.controller.webController;


import org.academiadecodigo.hackathon.persistence.model.Customer;
import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.model.product.Product;
import org.academiadecodigo.hackathon.services.PurchaseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cart")
@SessionAttributes({"customer", "purchase"})
public class CartController {

    private PurchaseServiceInterface purchaseService;

    @Autowired
    public void setPurchaseService(PurchaseServiceInterface purchaseService) {
        this.purchaseService = purchaseService;
    }

    @ModelAttribute("customer")
    public Customer sessionCustomer() {
        return new Customer();
    }
    @ModelAttribute("purchase")
    public Purchase sessionPurchase() {
        return new Purchase();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/badjoras")
    public void populateCustomer(@ModelAttribute("customer") Customer customer) {
        customer.setName("alfredo");
        System.out.println(customer.getName());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public void populatePurchase(@ModelAttribute("purchase") Purchase purchase) {
        System.out.println(purchase.getCustomer().getName());
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {

        return "redirect:/customer/1";
    }

}
