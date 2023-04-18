package com.bridgelabz.addressbook.exception;

public class AddressBookException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AddressBookException(String message) {
		
		this.message = message;
	}

}
