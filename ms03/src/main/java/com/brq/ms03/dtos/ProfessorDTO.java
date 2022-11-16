package com.brq.ms03.dtos;

import com.brq.ms03.models.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private int id;

    @NotEmpty(message = "campo em brancos")
    @NotNull(message = "Preenchimento Obrigatório")
    private String nome;
    private String disciplina;
    private String email;
    private String telefone;

    public ProfessorModel toModel(){

        ModelMapper mapper = new ModelMapper();

        ProfessorModel model = mapper.map(this , ProfessorModel.class );

        return model;
    }
}


