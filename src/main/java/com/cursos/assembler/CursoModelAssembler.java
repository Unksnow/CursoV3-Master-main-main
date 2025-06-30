package com.cursos.assembler;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import com.cursos.controller.CursoController;
import com.cursos.dto.Curso;
import com.cursos.dto.CursoModel;



@Component
public class CursoModelAssembler implements RepresentationModelAssembler<Curso, CursoModel> {

    @Override
    public CursoModel toModel(Curso curso) {
        CursoModel model = new CursoModel();
        model.setIdcurso(curso.getIdcurso());
        model.setNombreCurso(curso.getNombreCurso());
        model.setProfesor(curso.getProfesor());
        model.setAsignaturas(curso.getAsignaturas());

        model.add(linkTo(methodOn(CursoController.class).buscarCursos(curso.getIdcurso())).withSelfRel());
        model.add(linkTo(methodOn(CursoController.class).obtenerCursos()).withRel("Cursos"));
        model.add(linkTo(methodOn(CursoController.class).eliminarCurso(curso.getIdcurso())).withRel("Eliminar"));
        model.add(linkTo(methodOn(CursoController.class).actualizarCurso(curso.getIdcurso(), curso)).withRel("Actualizar"));

        return model;
    }
}