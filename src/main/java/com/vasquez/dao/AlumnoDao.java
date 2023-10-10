package com.vasquez.dao;

import com.vasquez.domain.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoDao extends CrudRepository<Alumno, Long> {
    
}
