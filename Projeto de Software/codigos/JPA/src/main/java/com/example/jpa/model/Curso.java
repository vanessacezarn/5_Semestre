package com.example.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity /*para sinalizar que será uma tabela no banco de dados*/
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*autoincremto do id*/
    private int id;
    /*demais atributos de curso*/
    private String nome;
    private String descricao;
    private int cargaHoraria;
    @OneToOne
    @JoinColumn(name="sala_id")/*mapeamento simple do bd*/
    private Sala sala;
    @ManyToMany
    @JoinTable(
            name="curso_professor",
            joinColumns = @JoinColumn(name="curso_id"), /*nome que a coluna terá e guardara o id dessa tabela (onde está a chave FK) */
            inverseJoinColumns = @JoinColumn(name="professor_id") /*guarda o id da outra tabela*/
    ) /*pois precisa de uma nova tabela para guardar as informações já que é para n..n, aqui está apenas dando o nome que a tabela terá no banco de dados*/
    private List<Professor> professores;

    /*sempre que um atributo reerenciar outra classe preciso adicionar a marcação acima dela, informando o relacionamento (1..1,1..n,n..n)*/
}
