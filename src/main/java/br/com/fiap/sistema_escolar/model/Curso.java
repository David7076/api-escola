package br.com.fiap.sistema_escolar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "cursos")
@Data
public class Curso {

    @Id
    private Long id;

    @Column(name = "nome_curso", length = 100, nullable = false)
    private String nome;

    private String reitor;

    private Double notaMec;

    private String nivel; //Superior, Técnico
}
