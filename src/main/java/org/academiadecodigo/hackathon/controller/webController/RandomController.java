package org.academiadecodigo.hackathon.controller.webController;

import org.academiadecodigo.hackathon.persistence.model.Purchase;
import org.academiadecodigo.hackathon.persistence.model.product.Product;
import org.academiadecodigo.hackathon.services.CustomerService;
import org.academiadecodigo.hackathon.services.ProductsService;
import org.academiadecodigo.hackathon.services.PurchaseService;
import org.academiadecodigo.hackathon.services.PurchaseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/random")
public class RandomController {


    private PurchaseServiceInterface purchaseService;
    private ProductsService productsService;

    @RequestMapping(method = RequestMethod.GET, value = {"", "/"})
    public String list(Model model, HttpServletRequest request) {
        Purchase currentPurchase = (Purchase) request.getSession().getAttribute("currentPurchase");
        List<Product> allProducts = productsService.listProducts();
        if(allProducts.size()!=0) {


            int np = (int) (Math.floor(Math.random() * (5 - 1) + 1));
            Map<Product, Integer> randomMap = new HashMap<>();

            for (int i = 0; i < np; i++) {
                randomMap.put(allProducts.get((int) (Math.floor(Math.random() * (allProducts.size() - 1) + 1))),
                        (int) (Math.floor(Math.random() * (4 - 1) + 1)));
            }

            for (Product p : randomMap.keySet()) {
                purchaseService.updateProduct(currentPurchase.getId(), p, randomMap.get(p));

            }
        }

        return "random";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/back", "/back/"})
    public String list(Model model) {
        //redirect to the view
        return "random";
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Autowired
    public void setPurchaseService(PurchaseServiceInterface purchaseService) {
        this.purchaseService = purchaseService;
    }
}

