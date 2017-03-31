package com.myfirstweb.Service;

import com.myfirstweb.Entity.Product;
import com.myfirstweb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id);
    }
    @Override
    public void deleteProductById(long id) {
        if (productRepository.count() >= id)
            productRepository.delete(id);
        else return;
    }
    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
    @Override
    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductByName(String name) {
    return     productRepository.findByName(name);
    }
}
