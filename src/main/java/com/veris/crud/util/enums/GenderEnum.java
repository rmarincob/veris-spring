package com.veris.crud.util.enums;

public enum GenderEnum {
	M("M"), F("F");
	
	private final String value;

	private GenderEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
