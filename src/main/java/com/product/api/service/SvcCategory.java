package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.common.ApiResponse;

/**
 * Interface for the Service used for Category object.
 */
public interface SvcCategory {
    /**
     * Getter for the categories.
     * 
     * @return A ResponseEntity with a List containing all the categories.
     */
    public ResponseEntity<List<Category>> getCategories();

    /**
     * Getter for all the active categories.
     * 
     * @return A ResponseEntity with a List containg all of the active categories.
     */
    public ResponseEntity<List<Category>> getActiveCategories();

    /**
     * Creates a category.
     * 
     * @param in Dto object with all of the required data.
     * @return A ResponseEntity with an ApiResponse.
     */
    public ResponseEntity<ApiResponse> createCategory(DtoCategoryIn in);

    /**
     * Updates an existing category.
     * 
     * @param in Dto object with all of the required data
     * @param id Id of the category we will be updating.
     * @return ResponseEntity with an ApiResponse
     */
    public ResponseEntity<ApiResponse> updateCategory(DtoCategoryIn in, Integer id);

    /**
     * Enables a category
     * 
     * @param id Id of the category
     * @return ResponseEntity with an ApiResponse
     */
    public ResponseEntity<ApiResponse> enableCategory(Integer id);

    /**
     * Disables a category.
     * 
     * @param id Id of the category
     * @return ResponseEntity with an ApiResponse
     */
    public ResponseEntity<ApiResponse> disableCategory(Integer id);

}
