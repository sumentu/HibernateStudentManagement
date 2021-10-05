package com.te.hibernatedemo.dao;

public class InvalidKeyException {
	String msg;

	public InvalidKeyException(String msg) {
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}
}
