package com.vasquez.service;

import com.vasquez.domain.Alumno;
import java.util.List;

public interface AlumnoService {

    public List<Alumno> listaAlumnos();

    public void guardar(Alumno alumno);

    public void eliminar(Alumno alumno);

    public Alumno encontrarAlumno(Alumno alumno);
}
