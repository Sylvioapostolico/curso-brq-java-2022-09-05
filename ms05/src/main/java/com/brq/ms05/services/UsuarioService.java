package com.brq.ms05.services;

import com.brq.ms05.models.UsuarioModel;
import com.brq.ms05.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioModel> getAll(){
        return repository.findAll();
    }

    public UsuarioModel create(UsuarioModel usuario){

        usuario.setId( counter );
        usuarios.add(usuario);
        counter++;

        // return "POST Usuários";
        return usuario;
    }

    public UsuarioModel update(int id, UsuarioModel usuarioBody){
        // como achar o usuário a ser alterado?
        for ( int i = 0; i <  usuarios.size(); i++ ){
            if (usuarios.get(i).getId() == id){
                // achamos o usuário a ser alterado
                usuarios.get(i).setNome( usuarioBody.getNome() );
                usuarios.get(i).setemail( usuarioBody.getEmail() );

                return usuarios.get(i);
            } // if
        }// for

        return null;
    }

    public String delete(int id){
        // FORECH
//        for (UsuarioModel usuarioLocal: usuarios) {
//            usuarios.remove(usuarioLocal);
//        }
        for (int i = 0; i < usuarios.size(); i++){
            // se achar o usuário, então delete do arraylist
            if (usuarios.get(i).getId() == id){
                usuarios.remove(i);
                return "Usuário delatado com sucesso!";
            } // if
        } // for
        return "Usuário não encontrado";
    }

    public UsuarioModel getOne(int id){
        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getId() == id){
                return usuarios.get(i);
            } // if
        } // for
        return null;
    }
}