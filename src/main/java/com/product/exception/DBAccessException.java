package com.product.exception;

import org.springframework.dao.DataAccessException;

/**
 * Class that handles the database exceptions.
 */
public class DBAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private DataAccessException exception;

	/*
	 * Constructor for the exception
	 */
	public DBAccessException(DataAccessException e) {
		this.exception = e;
	}

	/**
	 * Getter for the exception
	 * 
	 * @return the DataAccessException
	 */
	public DataAccessException getException() {
		return exception;
	}

	/**
	 * Sets the exception
	 * 
	 * @param exception The DataAccessException
	 */
	public void setException(DataAccessException exception) {
		this.exception = exception;
	}

	/**
	 * Getter for the serial version uid
	 * 
	 * @return The serial version uid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
