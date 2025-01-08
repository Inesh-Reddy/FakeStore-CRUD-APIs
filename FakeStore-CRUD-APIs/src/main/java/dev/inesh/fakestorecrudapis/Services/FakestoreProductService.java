package dev.inesh.fakestorecrudapis.Services;

import dev.inesh.fakestorecrudapis.Dtos.FakestoreProductServiceDto;
import dev.inesh.fakestorecrudapis.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.Objects;

@Service
public class FakestoreProductService implements ProductService {
    private final RestTemplate restTemplate;
    public FakestoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) {
        ResponseEntity<FakestoreProductServiceDto> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id,
                FakestoreProductServiceDto.class
        );
        return ResponseEntity.ok(
                Objects.requireNonNull(
                                response.getBody()
                        ).toProduct());
    }

    @Override
    public Product[] getAllProducts() {
        FakestoreProductServiceDto[] products = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                FakestoreProductServiceDto[].class
        );
        assert products != null;
        Product[] productArray = new Product[products.length];
        for(int i = 0; i < products.length; i++) {
            productArray[i] = products[i].toProduct();
        }
        return productArray;
    }

    @Override
    public Product createProduct(Long id, String title, String description, Double price, String category, String image) {
        FakestoreProductServiceDto fakestoreProductServiceDto = new FakestoreProductServiceDto();
        fakestoreProductServiceDto.setId(id);
        fakestoreProductServiceDto.setTitle(title);
        fakestoreProductServiceDto.setDescription(description);
        fakestoreProductServiceDto.setPrice(price);
        fakestoreProductServiceDto.setCategory(category);
        fakestoreProductServiceDto.setImage(image);

        return Objects.requireNonNull(restTemplate.postForObject(
                        "https://fakestoreapi.com/products/",
                        fakestoreProductServiceDto,
                        FakestoreProductServiceDto.class)
                ).toProduct();
    }

    @Override
    public String updateProduct(Long id, String title, String description, Double price, String category, String imageUrl) {
        FakestoreProductServiceDto fakestoreProductServiceDto = new FakestoreProductServiceDto();
        fakestoreProductServiceDto.setId(id);
        fakestoreProductServiceDto.setDescription(description);
        System.out.println(fakestoreProductServiceDto);
        String url = "https://fakestoreapi.com/products/" + id;
        restTemplate.put(url, fakestoreProductServiceDto);
        return "Product updated.";
    }

    @Override
    public String deleteProduct(Long id) {
        restTemplate.delete(
                "https://fakestoreapi.com/products/" + id
        );
        return MessageFormat.format(
                "deleted Product with id: {0}", id
        );
    }
}
