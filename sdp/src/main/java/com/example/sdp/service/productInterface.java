package com.example.sdp.service;

import com.example.sdp.entity.Product;

import java.util.List;

public interface productInterface {
    public String saveProduct(Product product);
    List<Product> findByCategory(String category);

    void updateProduct(Product product);

    Product findById(int id);
}
