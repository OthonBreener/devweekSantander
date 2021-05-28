package com.project.bootcamp.controller;


import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController // indica para o spring que esta classe é um controlador
@RequestMapping(value = "/stock") // o valor define a forma como vai ser acessado no url

public class StockController {

    @Autowired //
    private StockService service;

    // Diz que terei um tipo de resposta, onde vai ser salvo no banco de dados e retorna o objeto dto.
    // Consome um arquivo JSON e retorna um JSON

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.save(dto));

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {

        return ResponseEntity.ok(service.findAll());



        /*
        List<StockDTO> lista = new ArrayList<>();

        StockDTO dto = new StockDTO();

        dto.setId(1L);
        dto.setName("Magazine Luiza");
        dto.setPrice(100D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());

        lista.add(dto);
        return ResponseEntity.ok(lista);
        */
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(service.findById(id));



        /*
        List<StockDTO> lista = new ArrayList<>();
        StockDTO stock1 = new StockDTO();
        StockDTO stock2 = new StockDTO();

        stock1.setId(1L);
        stock1.setName("Magazine Luiza");
        stock1.setPrice(100D);
        stock1.setVariation(10D);
        stock1.setDate(LocalDate.now());

        stock2.setId(2L);
        stock2.setName("Ponto Frio");
        stock2.setPrice(200D);
        stock2.setVariation(20D);
        stock2.setDate(LocalDate.now());

        lista.add(stock1);
        lista.add(stock2);

        // stream é um recurso para percorrer uma lsita, filtrando o id pego com o id que esta sendo enviado
        StockDTO dtoSelect = lista.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();
        return ResponseEntity.ok(dtoSelect);
        */

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());
    }

}
