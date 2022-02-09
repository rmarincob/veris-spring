package com.veris.crud.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veris.crud.exceptions.custom.ConflictException;
import com.veris.crud.model.Doctor;
import com.veris.crud.repository.DoctorRepository;

@RestController()
@RequestMapping(value = "/api/doctors")
public class DoctorController {
	@Autowired

	private DoctorRepository doctorRepository;

	@GetMapping(value = { "/", "" })
	public ResponseEntity<Object> index() {
		Iterable<Doctor> doctors = doctorRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK)
				.body(Map.of("code", HttpStatus.OK.value(), "success", true, "message", "OK", "data", doctors));
	}

	@GetMapping(value = { "/{id}" })
	public ResponseEntity<Object> show(@PathVariable("id") Integer id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if (doctor.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(
					Map.of("code", HttpStatus.OK.value(), "success", true, "message", "OK", "data", doctor.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					Map.of("code", HttpStatus.NOT_FOUND.value(), "success", false, "message", "El recurso no existe!"));
		}
	}

	@GetMapping(value = { "/findByConditionals" })
	public ResponseEntity<Object> findByFilters(@RequestParam(required = true) Integer codeCompany,
			@RequestParam(required = true) String codeSucursal, @RequestParam(required = false) String valueSearch) {
		List<Doctor> doctors = doctorRepository.findByConditionals(codeCompany, codeSucursal, valueSearch);
		return ResponseEntity.status(HttpStatus.OK)
				.body(Map.of("code", HttpStatus.OK.value(), "success", true, "message", "OK", "data", doctors));
	}

	@PostMapping("/")
	public Doctor store(@Valid @RequestBody Doctor doctor) {
		Doctor _doctor = this.doctorRepository.findByNumberIdentification(doctor.getNumberIdentification());

		if (_doctor != null)
			throw new ConflictException(
					"La identificación " + doctor.getNumberIdentification() + " ya se encuentra registrado.");

		return doctorRepository.save(doctor);
	}
}
