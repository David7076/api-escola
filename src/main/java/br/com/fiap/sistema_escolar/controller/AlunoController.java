package br.com.fiap.sistema_escolar.controller;

import br.com.fiap.sistema_escolar.model.Aluno;
import br.com.fiap.sistema_escolar.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    AlunoRepository repository;

    AlunoController (AlunoRepository repository){
        this.repository = repository;
    }


    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return repository.
                findById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id,
                                          @RequestBody Aluno aluno) {

        Optional<Aluno> optAluno = repository.findById(id);

        if (optAluno.isPresent()) {
            aluno.setId(id);
            Aluno alunoAlterado = repository.save(aluno);
            return ResponseEntity.ok(alunoAlterado);
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
