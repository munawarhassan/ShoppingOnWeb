package com.ibm.shoponline.exception;

/**
 * @author SKHassan
 *
 */
public class ShoppingCartException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String reason;

	public ShoppingCartException(String reason) {
		super();
		this.reason = reason;
	}

}
