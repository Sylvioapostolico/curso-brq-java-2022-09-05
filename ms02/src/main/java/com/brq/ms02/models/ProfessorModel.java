package com.brq.ms02.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professores")
public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof")
    private int id;

    @Column(name = "nome_prof")
    private String nome;

    @Column(name = "email_prof")
    private String email;


  /*  ProfessorModel(){

    }
    ProfessorModel(int id, String nome, String email){

    }*/
}
