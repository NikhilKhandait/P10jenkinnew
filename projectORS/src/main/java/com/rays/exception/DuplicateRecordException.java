package com.rays.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * Nikhil Khandait 
 */
public class DuplicateRecordException extends RuntimeException {

	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException(String msg) {          //Unchecked exception
		super(msg);
	}

}