package com.example.productdemo.controller;


import com.example.productdemo.model.ProductModel;
import com.example.productdemo.ProductService.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("/")
    public List<ProductModel> getdetails() {
        System.out.println("get");
        return productService.findAll();
    }

    @PostMapping("/")
    public ProductModel create(@RequestBody ProductModel productModel) {
        System.out.println("Save");
        return productService.save(productModel);
    }

    @GetMapping("/{productId}")
    public ProductModel get(@PathVariable String productId) {
        Optional<ProductModel> productModel = productService.findById(productId);
        if (productModel.isPresent()) {
            System.out.println("get  id");
            return productModel.get();
        }
          return null;
    }
    @PutMapping("/{productId}")
    public ProductModel update(@PathVariable String productId, @RequestBody ProductModel productModel) {
        Optional<ProductModel> existingProductModel = productService.findById(productId);
        if(existingProductModel.isPresent()) {
            BeanUtils.copyProperties(productModel, existingProductModel);
            System.out.println("update");
            return productService.save(productModel);
        }
        return null;
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable String productId) {
        Optional<ProductModel> existingProductModel = productService.findById(productId);
        if(existingProductModel.isPresent()) {
            System.out.println("delete");
            productService.deleteById(productId);
        }
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
