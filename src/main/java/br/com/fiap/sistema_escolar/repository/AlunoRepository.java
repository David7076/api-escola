package br.com.fiap.sistema_escolar.repository;

import br.com.fiap.sistema_escolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
