package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class MainScreenControllerr {

    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

    public MainScreenControllerr(PartService partService, ProductService productService) {
        this.partService = partService;
        this.productService = productService;
    }

    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword,
            @Param("productkeyword") String productkeyword) {
        // Param = bind method parameters to a query via a named parameter.
        // add to the sprig model
        theParts = partService.listAll(partkeyword); // returns list of parts from DB
        theModel.addAttribute("parts", theParts); // adds whole list to model
        theModel.addAttribute("partkeyword", partkeyword); // adds keyword to model

        theProducts = productService.listAll(productkeyword); // returns list of products from DB
        theModel.addAttribute("products", theProducts); // adds whole list to model
        theModel.addAttribute("productkeyword", productkeyword); // adds keyword to model
        return "mainscreen";
    }
}
