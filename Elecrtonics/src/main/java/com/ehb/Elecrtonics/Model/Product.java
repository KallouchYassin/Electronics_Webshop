package com.ehb.Elecrtonics.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private @NotBlank String name;
    private @NotBlank String imageUrl;
    private @NotBlank Double price;
    private @NotBlank String description;
@ManyToOne
@JoinColumn(name="category_id")
Category category;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
