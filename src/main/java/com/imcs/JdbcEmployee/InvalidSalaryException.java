package com.imcs.JdbcEmployee;

public class InvalidSalaryException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSalaryException(String msg) {
		super(msg);
	}
}
