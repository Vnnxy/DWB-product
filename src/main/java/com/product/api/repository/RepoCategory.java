package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;

import jakarta.transaction.Transactional;

/**
 * Interface that extends JpaCategory, the methods required for the repositories
 * are defined here.
 */
@Repository
public interface RepoCategory extends JpaRepository<Category, Integer> {

    /**
     * Getter for all the categories.
     * 
     * @return A list containing all the categories.
     */
    @Query(value = "SELECT * FROM category ORDER BY category_id", nativeQuery = true)
    List<Category> getCategories();

    /**
     * Getter for all the active categories.
     * 
     * @return A list containing all the active categories.
     */
    @Query(value = "SELECT * FROM category WHERE status = 1 ORDER BY category_id", nativeQuery = true)
    List<Category> getActiveCategories();

    /**
     * Creates a category.
     * 
     * @param category The name of the category
     * @param tag      The tag of the category.
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO category (category, tag, status) VALUES (:category, :tag, 1)", nativeQuery = true)
    void createCategory(@Param("category") String category, @Param("tag") String tag);

    /**
     * Updates an existing category.
     * 
     * @param category_id Id of the category we want to update
     * @param category    Name of the category
     * @param tag         Tag of the category.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET category = :category, tag = :tag WHERE category_id = :category_id", nativeQuery = true)
    void updateCategory(@Param("category_id") Integer category_id, @Param("category") String category,
            @Param("tag") String tag);

    /**
     * Updates the status of a category, enabling or disabling it.
     * 
     * @param category_id Id of the category
     * @param status      The new status.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET status = :status WHERE category_id = :category_id;", nativeQuery = true)
    void updateCategoryStatus(@Param("category_id") Integer category_id, @Param("status") Integer status);

}
