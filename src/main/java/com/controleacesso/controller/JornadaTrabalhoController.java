package com.controleacesso.controller;

import com.controleacesso.model.JornadaTrabalho;
import com.controleacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaTrabalhoList(){
        return jornadaService.findAll();
    }

    @GetMapping("/{IdJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaTrabalhoByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(()->new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping
    public void deleteById(@RequestBody JornadaTrabalho jornadaTrabalho){
        try{
            jornadaService.deleteJornada(jornadaTrabalho);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}