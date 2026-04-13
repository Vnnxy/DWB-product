package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Dto object for creating and updating a product.
 * This object contains:
 * -product
 * -description
 * -price
 * -stock
 * -category
 */
public class DtoProductIn {

	@JsonProperty("gtin")
	@Pattern(regexp = "^\\+?\\d{13}$", message = "El gtin tiene un formato inválido")
	@NotNull(message = "El gtin es obligatorio")
	private String gtin;

	@JsonProperty("product")
	@NotNull(message = "El product es obligatorio")
	private String product;

	@JsonProperty("description")
	@NotNull(message = "El description es obligatorio")
	private String description;

	@JsonProperty("price")
	@Min(value = 0)
	@NotNull(message = "El price es obligatorio")
	private Float price;

	@JsonProperty("stock")
	@NotNull(message = "El stock es obligatorio")
	private Integer stock;

	@JsonProperty("category_id")
	@NotNull(message = "El category_id es obligatorio")
	private Integer category_id;

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
}
