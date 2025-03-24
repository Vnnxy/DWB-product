package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.api.dto.in.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.common.dto.ApiResponse;
import com.product.exception.ApiException;

/**
 * Svc category implementation.
 * Implements SvcCategory
 */
@Service
public class SvcCategoryImp implements SvcCategory {

	@Autowired
	RepoCategory repo;

	/**
	 * Getter for the categories.
	 * 
	 * @return A ResponseEntity with a List containing all the categories.
	 */
	@Override
	public ResponseEntity<List<Category>> getCategories() {
		try {
			return new ResponseEntity<>(repo.getCategories(), HttpStatus.OK);
		} catch (DataAccessException e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al consultar las categorías de la base de datos.");
		}

	}

	/**
	 * Getter for all the active categories.
	 * 
	 * @return A ResponseEntity with a List containg all of the active categories.
	 */
	@Override
	public ResponseEntity<List<Category>> getActiveCategories() {
		try {
			return new ResponseEntity<>(repo.getActiveCategories(), HttpStatus.OK);
		} catch (DataAccessException e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al consultar las categorías de la base de datos.");
		}
	}

	/**
	 * Creates a category.
	 * 
	 * @param in Dto object with all of the required data.
	 * @return A ResponseEntity with an ApiResponse.
	 */
	@Override
	public ResponseEntity<ApiResponse> createCategory(DtoCategoryIn in) {
		try {
			repo.createCategory(in.getCategory(), in.getTag());
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido registrada"), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			if (e.getLocalizedMessage().contains("ux_category"))
				throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoría ya está registrado");
			if (e.getLocalizedMessage().contains("ux_tag"))
				throw new ApiException(HttpStatus.CONFLICT, "El tag de la categoría ya está registrado");

			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al consultar las categorías de la base de datos.");
		}
	}

	/**
	 * Updates an existing category.
	 * 
	 * @param in Dto object with all of the required data
	 * @param id Id of the category we will be updating.
	 * @return ResponseEntity with an ApiResponse
	 */
	@Override
	public ResponseEntity<ApiResponse> updateCategory(DtoCategoryIn in, Integer id) {
		try {
			validateCategoryId(id);
			repo.updateCategory(id, in.getCategory(), in.getTag());
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido actualizada"), HttpStatus.OK);
		} catch (DataAccessException e) {
			if (e.getLocalizedMessage().contains("ux_category"))
				throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoría ya está registrado");
			if (e.getLocalizedMessage().contains("ux_tag"))
				throw new ApiException(HttpStatus.CONFLICT, "El tag de la categoría ya está registrado");

			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al consultar las categorías de la base de datos.");
		}
	}

	/**
	 * Enables a category
	 * 
	 * @param id Id of the category
	 * @return ResponseEntity with an ApiResponse
	 */
	@Override
	public ResponseEntity<ApiResponse> enableCategory(Integer id) {
		try {
			validateCategoryId(id);
			repo.updateCategoryStatus(id, 1);
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido activada"), HttpStatus.OK);
		} catch (DataAccessException e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al consultar las categorías de la base de datos.");
		}
	}

	/**
	 * Disables a category.
	 * 
	 * @param id Id of the category
	 * @return ResponseEntity with an ApiResponse
	 */
	@Override
	public ResponseEntity<ApiResponse> disableCategory(Integer id) {
		try {
			validateCategoryId(id);
			repo.updateCategoryStatus(id, 0);
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido desactivada"), HttpStatus.OK);
		} catch (DataAccessException e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al consultar las categorías de la base de datos.");
		}
	}

	/**
	 * Auxiliary method that validates the category id
	 * 
	 * @param id The category id.
	 * @throws ApiException
	 */
	private void validateCategoryId(Integer id) {
		try {
			if (repo.findById(id).isEmpty()) {
				throw new ApiException(HttpStatus.NOT_FOUND, "El id de la categoría no existe");
			}
		} catch (DataAccessException e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al consultar las categorías de la base de datos.");
		}
	}

}
