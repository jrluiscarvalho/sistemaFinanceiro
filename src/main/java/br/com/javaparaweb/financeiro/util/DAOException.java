package br.com.javaparaweb.financeiro.util;

public class DAOException extends Exception {
	public DAOException() {
		// TODO Auto-generated constructor stub
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Throwable cause) {
		super(cause);
	}
	
	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writebleStackTrace) {
		super(message, cause, enableSuppression, writebleStackTrace);
	}
}
