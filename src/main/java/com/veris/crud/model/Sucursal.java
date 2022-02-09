package com.veris.crud.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.veris.crud.util.enums.RegionEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "offices")
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "code_company")
	private Integer codeCompany;

	@Column(name = "code_sucursal")
	private String codeSucursal;

	@Column(name = "name_sucursal")
	private String nameSucursal;

	@Enumerated(EnumType.STRING)
	@Column(name = "region")
	private RegionEnum region;

	@Column(name = "user_register")
	private String userRegister;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_register")
	private LocalDate dateRegister;
}
