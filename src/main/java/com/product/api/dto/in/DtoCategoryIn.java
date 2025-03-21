package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Dto object for creating and updating a category.
 * This object contains:
 * -Category
 * -Tag
 */
public class DtoCategoryIn {

    @JsonProperty("category")
    @NotNull(message = "La categoría es obligatoria")
    private String category;

    @JsonProperty("tag")
    @NotNull(message = "El tag es obligatorio")
    private String tag;

    /**
     * Getter for the category
     * 
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for the category
     * 
     * @param category The category name
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for the tag
     * 
     * @return The tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Setter for the tag.
     * 
     * @param tag The tag of the category.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
