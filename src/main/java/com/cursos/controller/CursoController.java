package com.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.dto.Curso;
import com.cursos.services.CursoService;



import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v0/cursos")
@Tag(name = "Curso", description = "Operacion relacionadas con los Cursos")
public class CursoController {
    @Autowired
    private CursoService serviceCursos;

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
    @PutMapping("{idcurso}")
        public ResponseEntity<Curso> actualizarCurso(@PathVariable Integer idcurso, @RequestBody Curso cur){
            Curso aux = serviceCursos.actualizarCurso(cur, idcurso);
            if(aux == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(aux);
        }
    @GetMapping("/nombres")
        public List<String> obtenerNombresCursos() {
            return serviceCursos.obtenerNombresCursos();
        }
        
    @GetMapping("/profesor/{nombreProfesor}")
        public List<Curso> obtenerCursosPorProfesor(@PathVariable String nombreProfesor) {
            return serviceCursos.obtenerCursosPorProfesor(nombreProfesor);
        }    
    @DeleteMapping("{idcurso}")
        public ResponseEntity<Object> eliminarCurso(@PathVariable Integer idcurso){
            serviceCursos.eliminarCurso(idcurso);
            return ResponseEntity.noContent().build();

        }        

}
