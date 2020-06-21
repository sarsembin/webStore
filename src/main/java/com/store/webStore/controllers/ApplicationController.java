package com.store.webStore.controllers;

import com.store.webStore.entity.ProductType;
import com.store.webStore.repos.ProductRepository;
import com.store.webStore.entity.Product;
import com.store.webStore.repos.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ApplicationController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name){
        return String.format("Hello %s!", name);
    }

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


	/*@Bean
	public CommandLineRunner demo(ProductRepository repository){
		return (args) -> {
			repository.save(new Product("bounty", 300 ));
			repository.save(new Product("snickers", 350));
			repository.save(new Product("mars", 250));
			repository.save(new Product("mars", 220));

			log.info("Products found by findAll()");
			for(Product product : repository.findAll()){
				log.info(product.toString());
			}

			log.info("Product with id 2");
			Product productId2 = repository.findById(2);
			log.info(productId2.toString());

			log.info("Products with name mars");
			List<Product> marsBars = repository.findByName("mars");
			for(Product product : marsBars){
				log.info(product.toString());
			}


		};
	}*/
}
