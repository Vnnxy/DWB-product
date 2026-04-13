package com.product.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Ramón Arcos Morales, Miguel Akira Lopez Asano.
 *         <p>
 *         Class to represent Categories.
 *         </p>
 */
@Entity
@Table(name = "category")
public class Category {
    /** The category identifier. */
    @Id
    @JsonProperty("category_id")
    @Column(name = "category_id")
    private Integer category_id;

    /** The category name. */
    @JsonProperty("category")
    @Column(name = "category")
    private String category;

    /** The category tag. */
    @JsonProperty("tag")
    @Column(name = "tag")
    private String tag;

    /** The category status. */
    @JsonProperty("status")
    @Column(name = "status")
    private Integer status;

    /**
     * Empty constructor
     */
    public Category() {
    }

    /**
     * Constructs a category from the attributes.
     * 
     * @param category_id the id to use.
     * @param category    the name to use.
     * @param tag         the tag to use.
     * @param status      the status to use.
     */
    public Category(Integer category_id, String category, String tag, Integer status) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    /**
     * Returns the category id.
     * 
     * @return the category id.
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * Sets a new id.
     * 
     * @param category_id the new category id.
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    /**
     * Returns the category name.
     * 
     * @return the category name.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets a new name for a category.
     * 
     * @param category the new name.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the category tag.
     * 
     * @return the category tag.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets a new tag.
     * 
     * @param tag the new tag.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Returns the category status.
     * 
     * @return the category status.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets a new status.
     * 
     * @param status the new status.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Returns the string representation of a category.
     * 
     * @return the string that represents a category.
     */
    @Override
    public String toString() {
        return "{" + this.category_id.toString() + "," + this.category + "," + this.tag + "," + this.status.toString()
                + "}";
    }
}
