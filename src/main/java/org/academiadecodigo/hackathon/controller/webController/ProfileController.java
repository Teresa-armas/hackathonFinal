package org.academiadecodigo.hackathon.controller.webController;

import org.academiadecodigo.hackathon.persistence.model.Customer;
import org.academiadecodigo.hackathon.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"","/"})
    public String customerProfile(Model model, HttpServletRequest request) {

        //request.getSession().setAttribute("customer", customerService.get(1));
        //Customer customer = (Customer) request.getSession().getAttribute("customer");

        //if (customer == null) {

            Customer customer1 = new Customer();
            customer1.setName("manel");
            model.addAttribute("customer", customer1);
            return "profile";

       // }


        //model.addAttribute("customer",customer);

       // return "profile";

    }

}
