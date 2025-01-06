package dev.inesh.fakestorecrudapis.Services;

import dev.inesh.fakestorecrudapis.Models.Product;

public interface ProductService {
    Product createProduct(Long id, String title, String description, Double price, String category, String imageUrl);
    Product[] getAllProducts();
    Product getProductById(Long id);
    String updateProduct(Long id, String title, String description, Double price, String category, String imageUrl);
    String deleteProduct(Long id);
}
