package com.product.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Ramón Arcos Morales,Miguel Akira Lopez Asano.
 *         <p>
 *         Clase para representar Categorias.
 *         </p>
 */
@Entity
@Table(name = "category")
public class Category {
    /** El identificador de la categoría. */
    @Id
    private Integer category_id;

    /** El nombre de la categoría. */
    private String category;

    /** El tag de la categoría. */
    private String tag;

    /** El status de la categoría. */
    private Integer status;


    /**
     * Constructor vacío
     */
    public Category(){}

    /**
     * Construye una categoría a partir de los atributos.
     * 
     * @param category_id el id a usar.
     * @param category    el nombre a usar.
     * @param tag         el tag a usar.
     * @param status      el status a usar.
     */
    public Category(Integer category_id, String category, String tag, Integer status) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    /**
     * Regresa el id de la categoría.
     * 
     * @return el id de la categoría.
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * Define un nuevo id.
     * 
     * @param category_id el nuevo id de la categoría.
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    /**
     * Regresa el nombre de la categoría.
     * 
     * @return el nombre de la categoría.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Define un nuevo nombre a una categoría.
     * 
     * @param category el nuevo nombre.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Regresa el tag de la categoría.
     * 
     * @return el tag de la categoría.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Define un nuevo tag.
     * 
     * @param tag el nuevo tag.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Regresa el status de la categoría
     * 
     * @return el status de la categoría.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Define un nuevo status.
     * 
     * @param status el nuevo status.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Regresa la representación en cadena de una categoría.
     * 
     * @return la cadena que representa a una categoría.
     */
    @Override
    public String toString() {
        return "{" + this.category_id.toString() + "," + this.category + "," + this.tag + "," + this.status.toString()
                + "}";
    }
}
