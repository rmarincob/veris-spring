package com.veris.crud.util;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class ErrorResponse implements Serializable {
	private static final long serialVersionUID = -4549597389089697549L;

	private LocalDateTime timestamps;

	private String path;

	private int code;

	private String message;

	private String exception;

	private List<String> details;

	public ErrorResponse(Exception ex, String path, int code) {
		this.timestamps = LocalDateTime.now();
		this.message = ex.getMessage();
		this.exception = ex.getClass().getSimpleName();
		this.path = path;
		this.code = code;
	}

	public ErrorResponse(String message, Exception ex, String path, int code) {
		this.timestamps = LocalDateTime.now();
		this.message = message;
		this.exception = ex.getClass().getSimpleName();
		this.path = path;
		this.code = code;
	}

	public ErrorResponse(List<String> details, Exception ex, String path, int code) {
		this.timestamps = LocalDateTime.now();
		this.details = details;
		this.exception = ex.getClass().getSimpleName();
		this.path = path;
		this.code = code;
	}

	public ErrorResponse(String message, List<String> details, Exception ex, String path, int code) {
		this.timestamps = LocalDateTime.now();
		this.message = message;
		this.details = details;
		this.exception = ex.getClass().getSimpleName();
		this.path = path;
		this.code = code;
	}
}
