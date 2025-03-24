package com.product.api.service;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.common.dto.ApiResponse;

/**
 * Interface for the ProductImage service
 */
public interface SvcProductImage {

    /**
     * Uploads a product image
     * 
     * @param in a DtoProductImageIn in
     * @return ResponseEntity with an ApiResponse
     */
    public ResponseEntity<ApiResponse> uploadProductImage(DtoProductImageIn in);

    /**
     * Deletes a product image
     * 
     * @param product_image_id Id of the product image
     * @return ResponseEntity with an ApiResponse
     */
    public ResponseEntity<ApiResponse> deleteProductImage(Integer product_image_id);
}
