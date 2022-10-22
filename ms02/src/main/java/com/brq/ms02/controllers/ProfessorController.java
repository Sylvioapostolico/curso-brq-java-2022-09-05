package com.brq.ms02.controllers;

import com.brq.ms01.models.ProfessorModel;
import com.brq.ms01.services.Professorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


// comentário

/*
 * comentário
 * */

@RestController
public class ProfessorController {

    // private Professorservice profService = new Professorservice();
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo Professorservice
    @Autowired
    private Professorservice profService;

    /*
     * o @GetMapping permite associoar o verbo GET com a rota /Professor
     * */
    @GetMapping("professores")
    public List<ProfessorModel> getAllProfessores(){

        // ISSO É VERDADEIRO?????
        /*
         * EM JAVA, NÃÃÃÃÃÃÃOOOO SE COMPARA STRING COM OPERADOR ==
         * */
//        if ("aaa" == "aaa"){
//
//        }
//        if ("aaa".equalsIgnoreCase("aaa")){
//
//        }
        profService.mostrarMensagemService();
        //return Professor;
//        ArrayList<ProfessorModel> Professor = profService.getAllProfessor();
//          MANIPULAR AQUI
//        return Professor;

        return profService.getAllProfessores();
    }

    @PostMapping("professores")
    public ProfessorModel create(@RequestBody ProfessorModel professor){
//        ProfessorModel u = profService.create(professor);
//        return u;
        return profService.create(professor);

    } // create

    // /professores/1 -> o valor do id vai ser 1

    @PatchMapping("professores/{id}")
    public ProfessorModel update(@RequestBody ProfessorModel professorBody,
                               @PathVariable int id ){
        //        ProfessorModel u = profService.update(id, professorBody);
        //        return u;
        return profService.update(id, professorBody);
    } // update()

    @DeleteMapping("professores/{id}")
    public String delete(@PathVariable int id){

//        String response = profService.delete(id);
//        return response;

        return profService.delete(id);
    } // delete

    // busca por apenas um professor (pelo id)
    @GetMapping("professores/{id}")
    public ProfessorModel getOne(@PathVariable int id){

//        ProfessorModel u = profService.getOne(id);
//        return u;

        return profService.getOne(id);

    } // getOne

} // ProfessorController