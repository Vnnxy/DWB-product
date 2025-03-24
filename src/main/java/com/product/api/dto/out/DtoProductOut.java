package com.product.api.dto.out;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * Dto object of the product (responses)
 */
@Entity
@Table(name = "product")
public class DtoProductOut {

    /* Id of the product */
    @Id
    private Integer product_id;

    /* Gtin */
    private String gtin;

    /* The name of the product */
    private String product;

    /* The description of the product */
    private String description;
    /* The price of the product */
    private Float price;
    /* The remaining stock */
    private Integer stock;
    /* The category of the product */
    private String category;

    @Transient
    private List<String> images;

    /**
     * Getter for the product id
     * 
     * @return The product id.
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * Setter for the product id
     * 
     * @param product_id Id of the product
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * Getter for the gtin (unique identifier for the products)
     * 
     * @return String containing the gtin
     */
    public String getGtin() {
        return gtin;
    }

    /**
     * Setter for the gtin
     * 
     * @param gtin String containing the gtin
     */
    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    /**
     * Getter for the name of the product
     * 
     * @return The name of the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * Setter for the product
     * 
     * @param product Name of the product
     */
    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the price
     * 
     * @return The price of the product
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Setter for the price
     * 
     * @param price The price of the product
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Getter fo the stock
     * 
     * @return The stock remaining
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Setter for the stock
     * 
     * @param stock The stock remaining
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Getter for the category
     * 
     * @return The category name
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for the category
     * 
     * @param category The name of the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for all the images
     * 
     * @return List containing the images in base64
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * Setter for the images
     * 
     * @param images A list containing the base64 encoded images.
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

}
