package com.example.productdemo.ProductService;

import java.util.List;
import java.util.Optional;

import com.example.productdemo.model.ProductModel;


public interface ProductService {

    List<ProductModel> findAll();
    Optional<ProductModel> findById(String employeeId);
    ProductModel save(ProductModel productModel);
    void deleteById(String productId);

}
