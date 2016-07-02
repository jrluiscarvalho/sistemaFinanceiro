package br.com.javaparaweb.financeiro.util;

public class UtilException extends Exception {
	public UtilException() {
		// TODO Auto-generated constructor stub
	}
	
	public UtilException(String message) {
		super(message);
	}
	
	public UtilException(Throwable cause) {
		super(cause);
	}
	
	public UtilException(String message, Throwable cause, boolean enableSuppression, boolean writebleStackTrace) {
		super(message, cause, enableSuppression, writebleStackTrace);
	}
}
