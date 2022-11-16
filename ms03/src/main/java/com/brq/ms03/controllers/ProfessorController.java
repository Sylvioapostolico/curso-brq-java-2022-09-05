package com.brq.ms03.controllers;
import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


// comentário

/*
 * comentário
 * */

@RestController
public class ProfessorController {

    // private ProfessorService usuService = new ProfessorService();
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo ProfessorService
    @Autowired
    private ProfessorService profService;


    /*
     * o @GetMapping permite associoar o verbo GET com a rota /Professors
     * */
    @GetMapping("professores")
    public List<ProfessorDTO> getAllProfessores(){

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
        //return Professors;
//        ArrayList<ProfessorModel> Professors = usuService.getAllProfessors();
//          MANIPULAR AQUI
//        return Professors;

        return profService.getAllProfessores();
    }

    @PostMapping("professores")
    public ProfessorDTO create(@Valid @RequestBody ProfessorDTO professor){
//        ProfessorModel u = profService.create(professor);
//        return u;
        // return usuService.create(professor);
        var t = profService.create(professor);

        return t;

    } // create

    // /Professors/1 -> o valor do id vai ser 1

    @PatchMapping("professores/{id}")
    public ProfessorDTO update(@RequestBody ProfessorDTO ProfessorBody,
                             @PathVariable int id ){
        //        ProfessorModel u = profService.update(id, ProfessorBody);
        //        return u;
        return profService.update(id, ProfessorBody);
    } // update()

    @DeleteMapping("Professors/{id}")
    public String delete(@PathVariable int id){

//        String response = profService.delete(id);
//        return response;

        return profService.delete(id);
    } // delete

    // busca por apenas um usuário (pelo id)
    @GetMapping("professores/{id}")
    public ProfessorDTO getOne(@PathVariable int id){

//        ProfessorModel u = profService.getOne(id);
//        return u;

        return profService.getOne    (id);

    } // getOne

} // ProfessorController




