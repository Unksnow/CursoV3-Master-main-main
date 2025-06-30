package com.cursos.assembler;

import org.springframework.hateoas.server.RepresentationModelAssembler;
<<<<<<< HEAD
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
=======
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
import org.springframework.stereotype.Component;

import com.cursos.controller.CursoController;
import com.cursos.dto.Curso;
import com.cursos.dto.CursoModel;


<<<<<<< HEAD
=======
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145

@Component
public class CursoModelAssembler implements RepresentationModelAssembler<Curso, CursoModel> {

    @Override
    public CursoModel toModel(Curso curso) {
        CursoModel model = new CursoModel();
        model.setIdcurso(curso.getIdcurso());
        model.setNombreCurso(curso.getNombreCurso());
        model.setProfesor(curso.getProfesor());
<<<<<<< HEAD
        model.setAsignaturas(curso.getAsignaturas());

        model.add(linkTo(methodOn(CursoController.class).buscarCursos(curso.getIdcurso())).withSelfRel());
        model.add(linkTo(methodOn(CursoController.class).obtenerCursos()).withRel("Cursos"));
=======
        model.setAsignatura(curso.getAsignatura());

        model.add(linkTo(methodOn(CursoController.class).buscarCurso(curso.getIdcurso())).withSelfRel());
        model.add(linkTo(methodOn(CursoController.class).obteneCursos()).withRel("Cursos"));
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
        model.add(linkTo(methodOn(CursoController.class).eliminarCurso(curso.getIdcurso())).withRel("Eliminar"));
        model.add(linkTo(methodOn(CursoController.class).actualizarCurso(curso.getIdcurso(), curso)).withRel("Actualizar"));

        return model;
    }
}