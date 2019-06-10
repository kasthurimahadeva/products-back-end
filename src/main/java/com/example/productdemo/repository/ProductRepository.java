package com.example.productdemo.repository;
import com.example.productdemo.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<ProductModel, String>  {
}
