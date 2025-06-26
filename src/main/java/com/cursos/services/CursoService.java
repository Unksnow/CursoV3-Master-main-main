package com.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.dto.Curso;
//import com.cursos.repository.CursoRepository;
import com.cursos.repository.repositoryInterfaz;

@Service
public class CursoService {

    @Autowired
    private repositoryInterfaz repositoryInterfaz;

    public List<Curso> obtenerCursos() {
        return repositoryInterfaz.findAll();
    }

    public Curso buscarCursoPorId(int idcurso) {
        return repositoryInterfaz.findById(idcurso).orElse(null);
    }

    public Curso guardarCurso(Curso curso) {
        return repositoryInterfaz.save(curso);
    }

    public Curso actualizarCurso(Curso cur, Integer idcurso){
        Curso aux = buscarCursoPorId(idcurso);
        if (aux != null) {
            aux.setNombreCurso(cur.getNombreCurso());
            aux.setAsignaturas(cur.getAsignaturas());
            aux.setProfesor(cur.getProfesor());
            repositoryInterfaz.save(aux);
        }
        return aux;
    }

    public List<String> obtenerNombresCursos() {
        return repositoryInterfaz.findAllNombresCursos();
    }

    public List<Curso> obtenerCursosPorProfesor(String nombreProfesor) {
        return repositoryInterfaz.findByProfesorContainingIgnoreCase(nombreProfesor);
    }

    public void eliminarCurso(Integer idcurso) {
        Curso aux = buscarCursoPorId(idcurso);
        if(aux != null){
            repositoryInterfaz.delete(aux);
        }
        return;

    }
}