package com.product.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Ramón Arcos Morales, Miguel Akira Lopez Asano.
 *         <p>
 *         Class to represent Categories.
 *         </p>
 */
@Entity
@Table(name = "product")
public class Product {

	/* The product id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer product_id;
	/* The gtin (Unique product id) */
	@Column(name = "gtin")
	private String gtin;
	/* The product name */
	@Column(name = "product")
	private String product;
	/* The description product */
	@Column(name = "description")
	private String description;
	/* The price of the product */
	@Column(name = "price")
	private Float price;
	/* The stock remaining */
	@Column(name = "stock")
	private Integer stock;
	/* The category id */
	@Column(name = "category_id")
	private Integer category_id;
	/* Status of the product */
	@Column(name = "status")
	private Integer status;

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

	/**
	 * Getter for the description of the product
	 * 
	 * @return The description of the product
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for the product description
	 * 
	 * @param description The product description.
	 */
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
	 * Getter for the category id
	 * 
	 * @return The category id
	 */
	public Integer getCategory_id() {
		return category_id;
	}

	/**
	 * Setter for the category id
	 * 
	 * @param category_id The category id.
	 */
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	/**
	 * Getter for the status of the Product
	 * 
	 * @return The status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Setter for the status
	 * 
	 * @param status The current status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
