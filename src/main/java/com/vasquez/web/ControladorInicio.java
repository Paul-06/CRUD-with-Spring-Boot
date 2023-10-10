package com.vasquez.web;

import com.vasquez.domain.Alumno;
import com.vasquez.service.AlumnoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/")
    public String inicio(Model model) {
        var alumnos = alumnoService.listaAlumnos();
        log.info("Ejecuntado el controlador de Spring MVC");
        model.addAttribute("alumnos", alumnos);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Alumno alumno) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Alumno alumno) {
        alumnoService.guardar(alumno);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_alumno}")
    public String editar(Alumno alumno, Model model) {
        alumno = alumnoService.encontrarAlumno(alumno);
        model.addAttribute("alumno", alumno);
        return "modificar";
    }

    @GetMapping("/eliminar/{id_alumno}")
    public String eliminar(Alumno alumno) {
        alumnoService.eliminar(alumno);
        return "redirect:/";
    }

}
