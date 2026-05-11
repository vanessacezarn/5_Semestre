package com.example.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String especialidade;

    @OneToMany(cascade = CascadeType.ALL) /*para indicar o tipo de relacionamento*/
    @JoinColumn(name = "professor_id") /*pois será guardado na tabela de telefone já que é 1..N*/
    private List<Telefone> telefone;
}
