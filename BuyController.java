package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyController {
    // need repo to communicate w/ DB
    private ProductRepository productRepository;

    @Autowired // inject repo obj
    public BuyController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/buynow")
    public String purchaseConfirmation(@RequestParam("productID") long theInt) {
        if (productRepository.findById(theInt).get().getInv() > 0) {
            // retrieve product
            Product product = productRepository.findById(theInt).get();
            // delete productID so a new one can replace it
            productRepository.delete(product);
            // subtract 1 from inventory
            product.setInv(product.getInv() - 1);
            // update DB
            productRepository.save(product);

            return "confirmationpurchaseproduct";
        } else {
            return "purchasefailure";
        }
    }
}
