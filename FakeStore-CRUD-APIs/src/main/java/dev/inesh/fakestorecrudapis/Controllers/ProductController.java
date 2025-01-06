package dev.inesh.fakestorecrudapis.Controllers;

import dev.inesh.fakestorecrudapis.Dtos.FakestoreProductServiceDto;
import dev.inesh.fakestorecrudapis.Models.Product;
import dev.inesh.fakestorecrudapis.Services.FakestoreProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private FakestoreProductService fakestoreProductService;
    public ProductController(FakestoreProductService fakestoreProductService) {
        this.fakestoreProductService = fakestoreProductService;
    }

    @GetMapping(value = "/FakeStore/Products/{id}")
    public Product getProduct(@PathVariable long id) {
        return fakestoreProductService.getProductById(id);
    }

    @GetMapping(value = "/FakeStore/Products/")
    public Product[] getAllProducts() {
        return fakestoreProductService.getAllProducts();
    }

    @PostMapping("/FakeStore/Products")
    public Product createProduct(@RequestBody Product product) {
        return fakestoreProductService.createProduct(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getTitle(),
                product.getImage()
        );

    }

    @PutMapping(value = "/FakeStore/Products/")
    public String updateProduct(@RequestBody Product product) {
        return fakestoreProductService.updateProduct(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getTitle(),
                product.getImage()
        );
    }

    @DeleteMapping(value = "/FakeStore/Products/{id}")
    public String deleteProduct(@PathVariable long id) {
        return fakestoreProductService.deleteProduct(id);
    }
}
