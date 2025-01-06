package dev.inesh.fakestorecrudapis.Dtos;

import dev.inesh.fakestorecrudapis.Models.Category;
import dev.inesh.fakestorecrudapis.Models.Product;

public class FakestoreProductServiceDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);

        Category cat = new Category();
        cat.setTitle(category);
        product.setCategory(cat);

        return product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FakestoreProductServiceDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", imageUrl='" + image + '\'' +
                '}';
    }
}
