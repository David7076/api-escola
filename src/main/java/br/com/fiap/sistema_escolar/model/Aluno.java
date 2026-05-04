package br.com.fiap.sistema_escolar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "alunos")
@Data
public class Aluno {
    @Id
    private Long id;

    @Column(name = "nome_aluno", length = 100, nullable = false)
    private String nome;

    private String email;

    private Double rm;

    private String senha;
}
