package dev.inesh.fakestorecrudapis.Services;

import dev.inesh.fakestorecrudapis.Exceptions.ProductException;
import dev.inesh.fakestorecrudapis.Models.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    Product createProduct(Long id, String title, String description, Double price, String category, String imageUrl);
    Product[] getAllProducts();
    ResponseEntity<Product> getProductById(Long id) throws ProductException;
    String updateProduct(Long id, String title, String description, Double price, String category, String imageUrl);
    String deleteProduct(Long id);
}
