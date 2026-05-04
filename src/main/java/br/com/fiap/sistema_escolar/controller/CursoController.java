package br.com.fiap.sistema_escolar.controller;

import br.com.fiap.sistema_escolar.model.Aluno;
import br.com.fiap.sistema_escolar.model.Curso;
import br.com.fiap.sistema_escolar.repository.AlunoRepository;
import br.com.fiap.sistema_escolar.repository.CursoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    CursoRepository repository;

    CursoController (CursoRepository repository){
        this.repository = repository;
    }


    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        return repository.
                findById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id,
                                        @RequestBody Curso curso) {

        Optional<Curso> optCurso = repository.findById(id);

        if (optCurso.isPresent()) {
            curso.setId(id);
            Curso cursoAlterado = repository.save(curso);
            return ResponseEntity.ok(cursoAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
