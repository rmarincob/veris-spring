package com.veris.crud.util.enums;

public enum RegionEnum {
	COS("COS"), SIE("SIE"), ORI("ORI"), INS("INS");
	
	private final String value;

	private RegionEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
