package com.cursos.cursos;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cursos.controller.CursoController;
import com.cursos.model.Curso;
import com.cursos.services.CursoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CursoService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /api/v0/cursos devuelve lista de curso")
    public void testListarCurso() throws Exception {
        List<Curso> listaCursos = Arrays.asList(
            new Curso(1, "Introduccion a la programacion","Juan Perez", "programacion"),
            new Curso(2, "Calculo","Luis Fernandez", "Matematica")

        );

        when(service.obtenerCursos()).thenReturn(listaCursos);

        mockMvc.perform(get.)




    }



}
