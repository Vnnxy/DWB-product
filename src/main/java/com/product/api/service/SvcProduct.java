package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.in.DtoProductIn;
import com.product.api.dto.out.DtoProductListOut;
import com.product.api.dto.out.DtoProductOut;
import com.product.common.dto.ApiResponse;

/**
 * Interface for the Product Service.
 */
public interface SvcProduct {
	/**
	 * Getter for all of the products
	 * 
	 * @return A ResponseEntity with a List containing a DtoProductListOut
	 */
	public ResponseEntity<List<DtoProductListOut>> getProducts();

	/**
	 * Getter for the product
	 * 
	 * @param id Id of the product
	 * @return ResponseEntity with a DtoProductOut
	 */
	public ResponseEntity<DtoProductOut> getProduct(Integer id);

	/**
	 * Creates a product
	 * 
	 * @param in A DtoProductIn
	 * @return ResponseEntity with an ApiResponse
	 */
	public ResponseEntity<ApiResponse> createProduct(DtoProductIn in);

	/**
	 * Update a product
	 * 
	 * @param id Id of the product we want to update
	 * @param in a DtoProductIn with the required info
	 * @return ResponseEntity with an ApiResponse
	 */
	public ResponseEntity<ApiResponse> updateProduct(Integer id, DtoProductIn in);

	/**
	 * Enables a product
	 * 
	 * @param id Id of the product we want to enable
	 * @return ResponseEntity with an ApiResponse
	 */
	public ResponseEntity<ApiResponse> enableProduct(Integer id);

	/**
	 * Disables a product
	 * 
	 * @param id Id of the product we want to disable
	 * @return ResponseEntity with an ApiResponse
	 */
	public ResponseEntity<ApiResponse> disableProduct(Integer id);
}
