package com.veris.crud.util.enums;

public enum TypeIdentificationEnum {
	C("C"), R("R"), P("P");
	
	private final String value;

	private TypeIdentificationEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
