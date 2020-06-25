package com.store.webStore.controllers;

import com.store.webStore.entity.Product;
import com.store.webStore.entity.ProductType;
import com.store.webStore.entity.Response;
import com.store.webStore.repos.ProductRepository;
import com.store.webStore.repos.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestControllerAJAX {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;
    // NEW RESTCONTROLLER FOR AJAX,
    // THAT SENDS RESPONSE CLASS TO THE JS FILES IN JSON FORMAT,
    @GetMapping("/productListAJAX")
    public Response getProductsAJAX(){
        Response response = new Response(productRepository.findAll(), productTypeRepository.findAll());
        return response;
    }

    @PostMapping("/createProductAJAX")
    public Response addProductAJAX(@RequestParam String name, double price, Long type) {
        Optional<ProductType> pp = productTypeRepository.findById(type);
        productRepository.save(new Product(name, price, pp.get()));
        Response response = new Response(productRepository.findAll(), productTypeRepository.findAll());
        return response;
    }
    @PostMapping("/createProductTypeAJAX")
    public Response createProductTypeAJAX(@RequestParam String type){
        productTypeRepository.save(new ProductType(type));
        Response response = new Response(productRepository.findAll(), productTypeRepository.findAll());
        return response;
    }

    @PostMapping("/filterByTypeAJAX")
    public Response filterByTypeAJAX(@RequestParam List<Long> id){
        List<Product> products = new ArrayList<>();
        for(Long p : id){
            products.addAll(productRepository.findAllByProductType(productTypeRepository.findById(p).get()));
            System.out.println(p);
        }
        Response response= new Response(products, productTypeRepository.findAll());
        return response;
    }
}
