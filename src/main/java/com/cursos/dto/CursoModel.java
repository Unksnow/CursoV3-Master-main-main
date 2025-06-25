package com.cursos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoModel extends RepresentationModel<CursoModel> {

    private Integer idcurso;
    private String  nombreCurso;
    private String  profesor;
    private String  Asignaturas;

}
