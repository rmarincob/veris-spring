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
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.veris.crud.util.enums.GenderEnum;
import com.veris.crud.util.enums.TypeIdentificationEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_doctor")
	private Integer codeDoctor;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "El tipo de identificación no puede ser nulo.")
	@Column(name = "type_identification")
	private TypeIdentificationEnum typeIdentification;

	@NotEmpty(message = "El número de identificación es obligatorio.")
	@NotNull(message = "El número de identificación no puede ser nulo.")
	@Column(name = "number_identification")
	private String numberIdentification;

	@NotEmpty(message = "El primer nombre es obligatorio.")
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "second_name")
	private String secondName;

	@NotEmpty(message = "El primer apellido es obligatorio.")
	@Column(name = "first_lastname")
	private String firstLastname;

	@NotEmpty(message = "El segundo nombre es obligatorio.")
	@Column(name = "second_lastname")
	private String secondLastName;

	@NotEmpty(message = "El nombre completo es obligatorio.")
	@Column(name = "fullname")
	private String fullName;
	
	@Email(message = "El correo electrónico debe tener un formato válido.")
	@NotEmpty(message = "El correo electrónico es obligatorio.")
	@Column(name = "email")
	private String email;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@NotNull(message = "El salario no puede ser nulo.")
	@Column(name = "salary")
	private Double salary;
	
	@NotNull(message = "El género no puede ser nulo.")
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private GenderEnum gender;
	
	@NotNull(message = "El código de compañia no puede ser nulo.")
	@Column(name = "code_company")
	private Integer codeCompany;
	
	@NotEmpty(message = "El código de sucursal es obligatorio.")
	@NotNull(message = "El código de sucursal no puede ser nulo.")
	@Column(name = "code_sucursal")
	private String codeSucursal;
	
	@NotEmpty(message = "El usuario registrador es obligatorio.")
	@NotNull(message = "El usuario registrador no puede ser nulo.")
	@Column(name = "user_register")
	private String userRegister;
	
	@NotNull(message = "La fecha de registro no puede ser nulo.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_register")
	private LocalDate dateRegister;
}
