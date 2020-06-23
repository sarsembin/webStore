package com.store.webStore.controllers;

import com.store.webStore.entity.ProductType;
import com.store.webStore.repos.ProductRepository;
import com.store.webStore.entity.Product;
import com.store.webStore.repos.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;
    // Default get post
    @GetMapping("/productList")
    public String getAllProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("productsType", productTypeRepository.findAll()); //for drop down list
        return "products"; //products.html
    }

    @PostMapping("/createProduct")
    public String addProduct(@RequestParam String name, double price, Long type){
        ProductType pp = productTypeRepository.getOne(type);
        productRepository.save(new Product(name, price, pp));
        return "redirect:/productList";
    }

    @GetMapping("/searchProduct")
    public String searchProduct(Model model, @RequestParam String search){
        if (search.isEmpty()){
            model.addAttribute("products", productRepository.findAll());
        }
        else model.addAttribute("products", productRepository.findByName(search));
        model.addAttribute("productsType", productTypeRepository.findAll());
        return "products";
    }

    @GetMapping("/filterByType")
    public String filterByType(Model model, @RequestParam("checkbox") List<Long> id){
        List<Product> products = new ArrayList<>();
        for (Long p : id) {
            products.addAll(productRepository.findAllByProductType(productTypeRepository.getOne(p)));
        }
        model.addAttribute("products", products);
        model.addAttribute("productsType", productTypeRepository.findAll());
        return "products";
    }

    @PostMapping("/createProductType")
    public String createType(@RequestParam String type){
        productTypeRepository.save(new ProductType(type));
        return "redirect:/productList";
    }

    @GetMapping("/about")
    public String aboutUs(){
        return "about";
    }
}
