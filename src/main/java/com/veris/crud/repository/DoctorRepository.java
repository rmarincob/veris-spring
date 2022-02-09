package com.veris.crud.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.veris.crud.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	@Query(value = "SELECT * FROM doctors d WHERE (code_company = :codeCompany and code_sucursal = :codeSucursal) and (:valueSearch is null"
			+ " or fullname LIKE %:valueSearch%)", nativeQuery = true)
	List<Doctor> findByConditionals(@Param("codeCompany") Integer codeCompany,
			@Param("codeSucursal") String codeSucursal, @Param("valueSearch") String valueSearch);

	Doctor findByNumberIdentification(String numberIdentification);
}
