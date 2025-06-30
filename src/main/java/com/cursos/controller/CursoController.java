package com.cursos.controller;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
=======

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.cursos.assembler.CursoModelAssembler;
import com.cursos.dto.Curso;
import com.cursos.dto.CursoModel;
import com.cursos.services.CursoService;

=======

import com.cursos.dto.Curso;
import com.cursos.services.CursoService;



>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v0/cursos")
@Tag(name = "Curso", description = "Operacion relacionadas con los Cursos")
public class CursoController {
    @Autowired
    private CursoService serviceCursos;

<<<<<<< HEAD
    @Autowired
    private CursoModelAssembler assembler;

    @GetMapping("")
    public ResponseEntity<CollectionModel<CursoModel>> obtenerCursos(){
        List<Curso> curso = serviceCursos.obtenerCursos();
        if (curso.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<CursoModel> models = curso.stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(models));
    }

    @PostMapping("")
    public ResponseEntity<CursoModel> agregarCurso(@RequestBody Curso cur) {
        Curso saved = serviceCursos.guardarCurso(cur);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(assembler.toModel(saved));
    }
     
    @GetMapping("{idcurso}")
    public ResponseEntity<CursoModel> buscarCursos(@PathVariable Integer idcurso){
        Curso aux = serviceCursos.buscarCursoPorId(idcurso);
        if(aux == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assembler.toModel(aux));
    }
=======
    @GetMapping("")
        public List<Curso> obteneCursos(){
            return serviceCursos.obtenerCursos();
        }
    @PostMapping()
        public Curso guardarCurso(@RequestBody Curso cur){
            return serviceCursos.guardarCurso(cur);
        }
     
    @GetMapping("{idcurso}")
        public Curso buscarCurso(@PathVariable int idcurso){
            return serviceCursos.buscarCursoPorId(idcurso);
        }
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
    @PutMapping("{idcurso}")
        public ResponseEntity<Curso> actualizarCurso(@PathVariable Integer idcurso, @RequestBody Curso cur){
            Curso aux = serviceCursos.actualizarCurso(cur, idcurso);
            if(aux == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(aux);
        }
    @GetMapping("/nombres")
<<<<<<< HEAD
        public ModelAndView obtenerNombresCursos() {
        List<String> nombres = serviceCursos.obtenerNombresCursos();

    if (nombres == null || nombres.isEmpty()) {
        ModelAndView mav = new ModelAndView("mensaje"); 
        mav.addObject("mensaje", "No se encontraron nombres de cursos.");
        return mav;
        }

        ModelAndView mav = new ModelAndView("lista-nombres"); 
        mav.addObject("nombres", nombres);
        return mav;
=======
        public List<String> obtenerNombresCursos() {
            return serviceCursos.obtenerNombresCursos();
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
        }
        
    @GetMapping("/profesor/{nombreProfesor}")
        public List<Curso> obtenerCursosPorProfesor(@PathVariable String nombreProfesor) {
<<<<<<< HEAD
        List<Curso> cursos = serviceCursos.obtenerCursosPorProfesor(nombreProfesor);
    
        if (cursos == null || cursos.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el profesor: " + nombreProfesor);
        }

        return cursos;
        }  
=======
            return serviceCursos.obtenerCursosPorProfesor(nombreProfesor);
        }    
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
    @DeleteMapping("{idcurso}")
        public ResponseEntity<Object> eliminarCurso(@PathVariable Integer idcurso){
            serviceCursos.eliminarCurso(idcurso);
            return ResponseEntity.noContent().build();

        }        

}
