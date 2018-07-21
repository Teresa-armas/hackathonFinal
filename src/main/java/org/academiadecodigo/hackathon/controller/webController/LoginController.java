package org.academiadecodigo.hackathon.controller.webController;

import org.academiadecodigo.hackathon.persistence.model.Customer;
import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.model.product.Product;
import org.academiadecodigo.hackathon.services.CustomerService;
import org.academiadecodigo.hackathon.services.ProductsService;
import org.academiadecodigo.hackathon.services.PurchaseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("/")
public class LoginController {

    private PurchaseServiceInterface purchaseService;
    private CustomerService customerService;
    private ProductsService productsService;

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

    /*@RequestMapping(method = RequestMethod.GET, value = "/badjoras")
    public void populateCustomer(@ModelAttribute("customer") Customer customer) {
        customer.setName("alfredo");
        System.out.println(customer.getName());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public void populatePurchase(@ModelAttribute("purchase") Purchase purchase) {
        System.out.println(purchase.getCustomer().getName());
    }*/

    @RequestMapping(method = RequestMethod.POST, value = {"/millionDollar", "/millionDollar"})
    public String createCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {

        request.getSession().setAttribute("customer", Customer.class);
        Customer c = customerService.addCustomer(customer);
        Purchase purchase = new Purchase();
        purchase.setCustomer(c);
        Integer id =  purchaseService.add(purchase);

        purchaseService.updateProduct(id, new Product(), 1);
        return "redirect:/customer/cart";
    }

    @RequestMapping(method = RequestMethod.GET , value = "/login")
    public String login(Model model){

        model.addAttribute("customer", new Customer());

        return "login";

    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }
}
