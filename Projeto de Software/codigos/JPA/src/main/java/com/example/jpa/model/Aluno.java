package com.example.jpa.model;

import jakarta.persistence.*;

@Entity/*para sinalizar que será uma tabela no banco de dados*/
@Table (name="Estudantes") /*se já tiver um banco de dados preenchido, pode ser que no banco a tabela se chame Estudantes mas aqui a classe sera Aluno*/
public class Aluno {
    @Id /*sinaliza qual será a chave primária*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*autoincremto do id*/
    private int id;
    /*demais atributos de aluno*/
    private String nome;
    @Column(unique=true, nullable=false)
    private String cpf;
    @Column(unique=true, nullable=false)
    private String email;

    @ManyToOne
    @JoinColumn(name="curso_id") /*o banco de dados pode ter a coluna com nome curso_id mas aqui na classe será apenas curso*/
    private Curso curso;
}
