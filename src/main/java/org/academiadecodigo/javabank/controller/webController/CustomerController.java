package org.academiadecodigo.javabank.controller.webController;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CustomerController {

    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = {"", "/"})
    public String list(Model model) {
        //popular a lista no modelo

        Customer c = customerService.get(1);

        model.addAttribute("customer", c);

        return "list";

    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
