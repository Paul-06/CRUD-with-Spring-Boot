package com.vasquez.service;

import com.vasquez.dao.AlumnoDao;
import com.vasquez.domain.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoDao alumnoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> listaAlumnos() {
        return (List<Alumno>) alumnoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    @Transactional
    public void eliminar(Alumno alumno) {
        alumnoDao.delete(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno encontrarAlumno(Alumno alumno) {
        return alumnoDao.findById(alumno.getId_alumno()).orElse(null);
    }
}
