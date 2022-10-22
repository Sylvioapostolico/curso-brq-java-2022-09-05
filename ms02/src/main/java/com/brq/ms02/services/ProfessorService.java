package com.brq.ms02.services;

import com.brq.ms02.models.professorModel;
import com.brq.ms02.repositories.professorRepository;
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
    private ArrayList<com.brq.ms02.models.ProfessorModelModel> professores = new ArrayList<>();
    private int counter = 1;

    @Autowired
    private ProfessorServiceRepository usuRepository;

    public void mostrarMensagemService(){
        System.out.println("Mensagem do serviço");
    }

    public List<com.brq.ms02.models.ProfessorModelodel> getAllProfessores(){

        // a repository vai executar : SELECT * FROM professores;
        List<com.brq.ms02.models.ProfessorModelModel> list = usuRepository.findAll();

        return list;
        //return professores;
    }

    public com.brq.ms02.models.ProfessorModel create(com.brq.ms02.models.ProfessorModelModel uprofessor){

        // professor.setId( counter );
        //professores.add(professor);
        //counter++;

        // INSERT INTO professores (name_user, email_user ) VALUEs()....
        com.brq.ms02.models.ProfessorModel ProfessorSalvo = usuRepository.save( professor );
        // return  usuRepository.save( professor );
        // return "POST Professores";
        //return professor;
        return professorSalvo;
    }

    public com.brq.ms02.models.ProfessorModel update(int id, ProfessorModel professorBody)  {

        // ver se os dados existem
        Optional<professorModel> professorOptional = usuRepository.findById(id);

        // eu achei o usuário no banco de dados
        if (professorOptional.isPresent()){
            // retorna os valores do usuário encontrado no banco de dados
            professorModel meuprofessor = professorOptional.get();

            meuprofessor.setEmail( professorBody.getEmail() );
            meuprofessor.setNome( professorBody.getNome() );
            meuprofessor.setTelefone( professorBody.getTelefone());

            professorModel professorSalvo = usuRepository.save(meuprofessor);

            return professorSalvo;
        }
        // não achei o usuário no banco
        else{
            return professorOptional.orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
        }

//        // como achar o usuário a ser alterado?
//        for ( int i = 0; i <  professors.size(); i++ ){
//            if (professors.get(i).getId() == id){
//                // achamos o usuário a ser alterado
//                professors.get(i).setNome( professorBody.getNome() );
//                professors.get(i).setEmail( professorBody.getEmail() );
//
//                return professors.get(i);
//            } // if
//        }// for
//
//        return null;
    }

    public String delete(int id){
        // FORECH
//        for (professorModel professorLocal: professors) {
//            professors.remove(professorLocal);
//        }
//        for (int i = 0; i < professors.size(); i++){
//            // se achar o usuário, então delete do arraylist
//            if (professors.get(i).getId() == id){
//                professors.remove(i);
//                return "Usuário delatado com sucesso!";
//            } // if
//        } // for
//        return "Usuário não encontrado";

        usuRepository.deleteById(id);
        return "Usuário delatado com sucesso!";
    }

    public professorModel getOne(int id){

        Optional<professorModel> professorOptional = usuRepository.findById(id);

        if (professorOptional.isPresent()){
            professorModel professor = professorOptional.get();

            return professor;
        }
        else {
            return professorOptional.orElseThrow( ()-> new RuntimeException("Usuário não localizado") );
        }

//        for (int i = 0; i < professors.size(); i++){
//            if (professors.get(i).getId() == id){
//                return professors.get(i);
//            } // if
//        } // for
//        return null;
    }
}