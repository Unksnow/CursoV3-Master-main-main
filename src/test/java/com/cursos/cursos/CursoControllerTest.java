package com.cursos.cursos;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.Link;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cursos.assembler.CursoModelAssembler;
import com.cursos.controller.CursoController;
import com.cursos.dto.Curso;
import com.cursos.dto.CursoModel;
import com.cursos.services.CursoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CursoService service;

    @MockitoBean
    private CursoModelAssembler assembler;

    @Autowired
    private ObjectMapper objectMapper;

    public static class DummyCursoModel extends CursoModel {
        public DummyCursoModel(Curso cur) {
            this.setIdcurso(cur.getIdcurso());
            this.setNombreCurso(cur.getNombreCurso());
            this.setProfesor(cur.getProfesor());
            this.setAsignaturas(cur.getAsignaturas());
            this.add(Link.of("https://localhost/api/v0/cursos/" + cur.getIdcurso()).withSelfRel());

        }
    }

    @Test
    @DisplayName("GET /api/v0/cursos retorna un 404 si no hay cursos")
    public void testListarCursosVacios() throws Exception {
        when(service.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/v0/cursos/"));
    }





    



}
