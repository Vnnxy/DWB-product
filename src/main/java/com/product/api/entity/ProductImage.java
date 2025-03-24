package com.product.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Ramón Arcos Morales, Miguel Akira Lopez Asano.
 *         Class for the product image
 * 
 */
@Entity
@Table(name = "product_image")
public class ProductImage {

    /* The if of the image */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Integer product_image_id;
    /* The product id */
    @Column(name = "product_id")
    private Integer product_id;
    /* The base64 image */
    @Column(name = "image")
    private String image;
    /* Status of the image */
    @Column(name = "status")
    private Integer status;

    /**
     * Getter for the product image id
     * 
     * @return The product image id
     */
    public Integer getProduct_image_id() {
        return product_image_id;
    }

    /**
     * Setter for the product image id
     * 
     * @param product_image_id The id of the product image
     */
    public void setProduct_image_id(Integer product_image_id) {
        this.product_image_id = product_image_id;
    }

    /**
     * Getter for the product id
     * 
     * @return The product id.
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * /**
     * Setter for the product id
     * 
     * @param product_id Id of the product
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * Getter for the image
     * 
     * @return String containing the image in base64.
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter for the image
     * 
     * @param image String of the image in base64
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter for the product image status
     * 
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Setter for the product image status
     * 
     * @param status The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
