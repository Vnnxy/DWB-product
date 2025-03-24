package com.product.api.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto object for the Products
 */
public class DtoProductListOut {

	/* Product id */
	@JsonProperty("product_id")
	private Integer product_id;
	/* Gtin */
	@JsonProperty("gtin")
	private String gtin;
	/* Product */
	@JsonProperty("product")
	private String product;
	/* Price */
	@JsonProperty("price")
	private Float price;
	/* Status */
	@JsonProperty("status")
	private Integer status;

	/**
	 * Public constructor for the DtoProductListOut
	 * 
	 * @param product_id Id for the product_id
	 * @param gtin       The gtin
	 * @param product    Name of the product
	 * @param price      Price of the price
	 * @param status     Status of the product
	 */
	public DtoProductListOut(Integer product_id, String gtin, String product, Float price, Integer status) {
		super();
		this.product_id = product_id;
		this.gtin = gtin;
		this.product = product;
		this.price = price;
		this.status = status;
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
	 * Getter for the status
	 * 
	 * @return The current status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Setter for the status
	 * 
	 * @param status The status of the product
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
