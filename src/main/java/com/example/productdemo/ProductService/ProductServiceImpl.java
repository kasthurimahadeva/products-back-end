
package com.example.productdemo.ProductService;


import com.example.productdemo.model.ProductModel;
import com.example.productdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;


    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> findById(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public void deleteById(String productId) {
        productRepository.deleteById(productId);
    }

    @Autowired
    public  void setProductRepository(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


}