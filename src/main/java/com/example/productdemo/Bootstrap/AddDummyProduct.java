package com.example.productdemo.Bootstrap;



import com.example.productdemo.model.ProductModel;
import com.example.productdemo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j

public class AddDummyProduct {

    @Bean
    CommandLineRunner initProductDataBase(ProductRepository productRepository) {
        return args -> { productRepository.save(new ProductModel("001", "Sana", "45",
                "https://i.pinimg.com/originals/1a/79/e1/1a79e169e38d19a39aa52853922be8be.jpg",
                "314"));

        };
    }

}



