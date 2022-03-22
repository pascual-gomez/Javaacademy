package com.pascualgomez.springdatademo.controllers;

import com.pascualgomez.springdatademo.entities.Product;
import com.pascualgomez.springdatademo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public @ResponseBody void addProduct(@RequestBody Product p) {
        productRepository.save(p);
    }

    @GetMapping("/get/{name}")
    public @ResponseBody Product getProduct(@PathVariable("name") String name) {
        return productRepository.findProductByName(name);
    }
}
