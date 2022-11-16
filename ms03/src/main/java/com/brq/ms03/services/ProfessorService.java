package com.brq.ms03.services;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
 * A camada Service é responsável por armazenar as regras de negócio da aplicação
 * */
@Service
public class ProfessorService {

    // ESTE ARRAYLIST É DIDÁTICO, POIS ESTÁ SIMULANDO UM BANCO DE DADOS
    private ArrayList<ProfessorModel> professores = new ArrayList<>();
    private int counter = 1;

    @Autowired
    private ProfessorRepository profRepository;

    public void mostrarMensagemService(){
        System.out.println("Mensagem do serviço");
    }

    public List<ProfessorDTO> getAllProfessores(){

        // a repository vai executar : SELECT * FROM usuarios;
        List<ProfessorModel> list = profRepository.findAll();

        // COMO CONVERTER UMA LISTA DE MODEL PARA LISTA DE DTO?

        List<ProfessorDTO> listDTO = new ArrayList<>();

        // Tipo da variável -
        for (ProfessorModel balde : list) {
            listDTO.add( balde.toDTO() );
        }

        return listDTO;
        //return usuarios;
    }

    public ProfessorDTO create(ProfessorDTO professor){

        // usuario.setId( counter );
        //usuarios.add(usuario);
        //counter++;

        // TEMOS QUE CONVERTER UM DTO PARA UM MODEL
        // jeito Fabrizio (Burro)
//        UsuarioModel usuarioDTOtoModel = new UsuarioModel();
//        usuarioDTOtoModel.setId( usuario.getId() );
//        usuarioDTOtoModel.setNome(usuario.getNome());
//        usuarioDTOtoModel.setTelefone(usuario.getTelefone());
//        usuarioDTOtoModel.setEmail(usuario.getEmail());

        // INSERT INTO usuarios (name_user, email_user ) VALUEs()....
        ProfessorModel professorSalvo = profRepository.save( professor.toModel() );
        // return  usuRepository.save( usuario );
        // return "POST Usuários";
        //return usuario;
        return professorSalvo.toDTO();
    }

    public ProfessorDTO update(int id, ProfessorDTO professorBody)  {

        ProfessorModel professor = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        professorBody.setNome( professorBody.getNome() );
        professorBody.setDisciplina( professorBody.getDisciplina());
        professorBody.setEmail( professorBody.getEmail() );
        professorBody.setTelefone( professorBody.getTelefone() );

        return profRepository.save(professor).toDTO();


//        // ver se os dados existem
//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//
//        // eu achei o usuário no banco de dados
//        if (usuarioOptional.isPresent()){
//            // retorna os valores do usuário encontrado no banco de dados
//            UsuarioModel meuUsuario = usuarioOptional.get();
//
//            meuUsuario.setEmail( usuarioBody.getEmail() );
//            meuUsuario.setNome( usuarioBody.getNome() );
//
//            UsuarioModel usuarioSalvo = usuRepository.save(meuUsuario);
//
//            return usuarioSalvo;
//        }
//        // não achei o usuário no banco
//        else{
//            return usuarioOptional.orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
//        }

//        // como achar o usuário a ser alterado?
//        for ( int i = 0; i <  usuarios.size(); i++ ){
//            if (usuarios.get(i).getId() == id){
//                // achamos o usuário a ser alterado
//                usuarios.get(i).setNome( usuarioBody.getNome() );
//                usuarios.get(i).setEmail( usuarioBody.getEmail() );
//
//                return usuarios.get(i);
//            } // if
//        }// for
//
//        return null;
    }

    public String delete(int id){
        // FORECH
//        for (UsuarioModel usuarioLocal: usuarios) {
//            usuarios.remove(usuarioLocal);
//        }
//        for (int i = 0; i < usuarios.size(); i++){
//            // se achar o usuário, então delete do arraylist
//            if (usuarios.get(i).getId() == id){
//                usuarios.remove(i);
//                return "Usuário delatado com sucesso!";
//            } // if
//        } // for
//        return "Usuário não encontrado";

        profRepository.deleteById(id);
        return "Professor delatado com sucesso!";
    }

    public ProfessorDTO getOne(int id){

        ProfessorModel usuario = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado"));

        return usuario.toDTO();
//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//
//        if (usuarioOptional.isPresent()){
//            UsuarioModel usuario = usuarioOptional.get();
//
//            return usuario;
//        }
//        else {
//            return usuarioOptional.orElseThrow( ()-> new RuntimeException("Usuário não localizado") );
//        }


//        for (int i = 0; i < usuarios.size(); i++){
//            if (usuarios.get(i).getId() == id){
//                return usuarios.get(i);
//            } // if
//        } // for
//        return null;
    }
}
