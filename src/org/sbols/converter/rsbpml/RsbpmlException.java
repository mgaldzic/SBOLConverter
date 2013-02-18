package org.sbols.converter.rsbpml;



public class RsbpmlException extends RuntimeException  {
	/**
	 * Creates a new exception instance with the given message and objects causing the problem.
	 */
	public RsbpmlException(String message) {
		super(message);
	}
	
	public RsbpmlException(String message, Throwable cause) {
		super(message, cause);
	}
}
