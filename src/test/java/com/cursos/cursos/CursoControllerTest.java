package com.cursos.cursos;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        when(service.obtenerCursos()).thenReturn(List.of());

        mockMvc.perform(get("/api/v0/cursos/"))
            .andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("GET /api/v0/cursos/{idcurso} retorna 404 si no esiste")
    public void testBuscarPorIdNoExistente() throws Exception {
        when(service.buscarCursoPorId(99)).thenReturn(null);

        mockMvc.perform(get("/api/v0/cursos/99")).andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("DELETE /api/v0/cursos/{idcurso} elimina el usuario existente")
    public void testEliminarUsuario() throws Exception {
        doNothing().when(service).eliminarCurso(6);

        mockMvc.perform(delete("/api/v0/cursos/6"))
            .andExpect(status().isNoContent());
    }
    @Test
    @DisplayName("POST /api/v0/cursos crea un curso")
    public void testAgregarCurso() throws Exception {
        Curso nuevo = new Curso(3, "Matematica", "Luis", "Algebra");
        Curso guardado = new Curso(3, "Matematica", "Luis", "Algebra");

        when(service.guardarCurso(any(Curso.class))).thenReturn(guardado);
        when(assembler.toModel(any(Curso.class))).thenReturn(new DummyCursoModel(guardado));

        mockMvc.perform(post("/api/v0/cursos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nuevo)))
            .andDo(print())    
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.nombreCurso").value("Matematica"))
            .andExpect(jsonPath("$.idcurso").value(3))
            .andExpect(jsonPath("$.profesor").value("Luis"))
            .andExpect(jsonPath("$.asignaturas").value("Algebra"));
    }

    @Test
    @DisplayName("GET /api/v0/cursos/{idcurso} retorna usuario existente")
    public void testBuscarPorIdExistente() throws Exception {
        Curso cur = new Curso(4, "Programacion", "Luis", "Java");

        when(service.buscarCursoPorId(4)).thenReturn(cur);
        when(assembler.toModel(any(Curso.class))).thenReturn(new DummyCursoModel(cur));

        mockMvc.perform(get("/api/v0/cursos/{idcurso}", 4))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.idcurso").value(4))
        .andExpect(jsonPath("$.nombreCurso").value("Programacion"))
        .andExpect(jsonPath("$.profesor").value("Luis"))
        .andExpect(jsonPath("$.asignaturas").value("Java"));       

        }
    @Test
    @DisplayName("PUT /api/v0/cursos/{idcurso} actualiza curso existente")
    public void testActualizarCurso() throws Exception {
        Curso actualizado = new Curso(5, "Lenguaje", "Javier", "Lectura");

        when(service.actualizarCurso(any(Curso.class), eq(5))).thenReturn(actualizado);
        when(assembler.toModel(any(Curso.class))).thenReturn(new DummyCursoModel(actualizado));


         mockMvc.perform(put("/api/v0/cursos/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(actualizado)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombreCurso").value("Lenguaje"));       
        
    }
    @Test
    @DisplayName("PUT /api/v0/cursos/{idcurso} retorna un 404 si no se encuentra el curso")
    public void testActualizarCursoNoEncontrado() throws Exception {
        when(service.actualizarCurso(any(Curso.class) , eq(88))).thenReturn(null);

        mockMvc.perform(put("/api/v0/cursos/88")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Curso())))
            .andExpect(status().isNotFound());       
    }




    



}
