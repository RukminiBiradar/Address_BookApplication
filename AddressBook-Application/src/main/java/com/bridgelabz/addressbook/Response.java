package com.bridgelabz.addressbook;

public class Response {
	
	String message;
	Object addressBook;

	public Response(String message, Object addressBookModel) {
		this.message = message;
		this.addressBook = addressBookModel;
	}

	public Response(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Object getUser() {
		return addressBook;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setUser(Object user) {
		this.addressBook = user;
	}

}

	


