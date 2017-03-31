package com.myfirstweb.Service;

import com.myfirstweb.Entity.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> getAllProducts();
    Product getProductById(long id);
    void deleteProductById(long id);
    void updateProduct(Product product);
    void insertProduct(Product product);

    Product getProductByName(String name);
}
