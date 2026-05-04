package br.com.fiap.sistema_escolar.repository;

import br.com.fiap.sistema_escolar.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
