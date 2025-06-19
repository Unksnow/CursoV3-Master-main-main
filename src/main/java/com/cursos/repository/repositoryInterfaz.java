package com.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cursos.model.Curso;

@Repository
public interface repositoryInterfaz extends JpaRepository<Curso, Integer> {

    List<Curso> findByProfesorContainingIgnoreCase(String nombreProfesor);

    
    @Query("SELECT c.nombreCurso FROM Curso c")
        List<String> findAllNombresCursos();
    }
    


