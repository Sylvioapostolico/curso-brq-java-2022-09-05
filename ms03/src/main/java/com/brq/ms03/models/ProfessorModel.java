package com.brq.ms03.models;

import com.brq.ms03.dtos.ProfessorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

/*
 * @Data, que faz o papel dos Getters, Setters e toString()
 * @Entity "diz" que a classe UsuarioModel vai ser mapeada com uma tabela no banco de dados
 * @Table especifica o nome da tabela que esta classe vai mapear
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professores")

public class ProfessorModel {

    // UUID -> é um conjunto de letras e números para identificar unicamente um registro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof")
    private int id;

    @Column(name = "nome_prof")
    private String nome;

    @Column(name = "disciplina")
    private String disciplina;

    @Column(name = "email_prof")
    private String email;

    @Column(name = "telefone_prof   ")
    private String telefone;

    public ProfessorDTO toDTO(){
        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, ProfessorDTO.class);
    }
}

