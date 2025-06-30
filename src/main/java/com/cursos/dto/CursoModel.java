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
<<<<<<< HEAD
    private String  asignaturas;
=======
    private String  Asignaturas;
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145

}
