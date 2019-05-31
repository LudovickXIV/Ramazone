package com.ramazone.ramazone.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productname;
    private double price;
    private String discription;

    @ElementCollection(targetClass = Category.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private Set<Category> category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String name) {
        this.productname = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
