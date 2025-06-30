package com.cursos.cursos;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.cursos.dto.Curso;
import com.cursos.repository.repositoryInterfaz;
import com.cursos.services.CursoService;

public class CursoServiceTest {

    @Mock
    private repositoryInterfaz repositoryInterfaz;

    @InjectMocks
    private CursoService cursoService;

    private Curso cursoEjemplo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cursoEjemplo = new Curso(1, "Matemáticas", "Juan Pérez", "Álgebra");
    }

    @Test
    public void testObtenerCursos() {
        when(repositoryInterfaz.findAll()).thenReturn(List.of(cursoEjemplo));
        List<Curso> cursos = cursoService.obtenerCursos();
        assertEquals(1, cursos.size());
        assertEquals("Matemáticas", cursos.get(0).getNombreCurso());
    }

    @Test
    public void testBuscarCursoPorId_existente() {
        when(repositoryInterfaz.findById(1)).thenReturn(Optional.of(cursoEjemplo));
        Curso curso = cursoService.buscarCursoPorId(1);
        assertNotNull(curso);
        assertEquals("Juan Pérez", curso.getProfesor());
    }

    @Test
    public void testGuardarCurso() {
        when(repositoryInterfaz.save(cursoEjemplo)).thenReturn(cursoEjemplo);
        Curso result = cursoService.guardarCurso(cursoEjemplo);
        assertEquals("Matemáticas", result.getNombreCurso());
    }

    @Test
    public void testEliminarCurso_existente() {
        when(repositoryInterfaz.findById(1)).thenReturn(Optional.of(cursoEjemplo));
        cursoService.eliminarCurso(1);
        verify(repositoryInterfaz, times(1)).delete(cursoEjemplo);
    }
}

