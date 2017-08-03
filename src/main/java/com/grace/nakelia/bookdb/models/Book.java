package com.grace.nakelia.bookdb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {



    @NotNull
    @Size(min=2, max=30)
    @Id
    private String sku;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    @Size(min=2, max=100)
    private String description;

    private double price;


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void set(String SKU, String title, String author,String description, double price){
        setSku(SKU);
        setTitle(title);
        setAuthor(author);
        setDescription(description);
        setPrice(price);
    }
}
