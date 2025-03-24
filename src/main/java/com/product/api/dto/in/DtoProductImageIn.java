package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Dto object for creating and updating a product image.
 * This object contains:
 * -product id
 * -image
 */
public class DtoProductImageIn {
    @JsonProperty("product_id")
    @NotNull(message = "El product_id es obligatorio")
    private Integer product_id;

    @JsonProperty("image")
    @NotNull(message = "El image es obligatorio")
    private String image;

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
}
