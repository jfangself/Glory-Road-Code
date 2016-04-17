package com.fangdd.utils.http.base;

public enum UserAgent {
	FANGDD_SDK_JAVA("fangdd-sdk-java");

	private String code;

	private UserAgent(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}