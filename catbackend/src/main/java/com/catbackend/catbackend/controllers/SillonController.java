package com.catbackend.catbackend.controllers;

import com.catbackend.catbackend.models.Sillon;
import com.catbackend.catbackend.services.SillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sillones")
public class SillonController {

    @Autowired
    @Qualifier("SillonService")
    private SillonService sillonService;

    @GetMapping("")
    public Iterable<Sillon> getSillones(){
        return sillonService.listAll();
    }

    @GetMapping("/search/estado")
    public Iterable<Sillon> getSillonesByState(@RequestParam(value="estado") final String estado){
        return sillonService.findSillonByState(estado);
    }

    @GetMapping("/search/encargado/{id}")
    public Iterable<Sillon> getSillonesByEncargado(@PathVariable final Long id){
        return sillonService.findSillonByEncargado(id);
    }


    @PostMapping("")
    public ResponseEntity<Sillon> addSillon(@RequestBody final Sillon sillon){
        final Sillon aux = sillonService.saveOrUpdateSillon(sillon);
        return new ResponseEntity<Sillon>(aux, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSillon(@PathVariable final Long id){
        final Sillon aux = sillonService.findSillonById(id);
        if(aux!=null) {
            return new ResponseEntity<Sillon>(aux, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSillon(@PathVariable final Long id,@RequestBody final Sillon newSillon){
        final Sillon aux = sillonService.findSillonById(id);
        if(aux!=null){
            aux.setIdEncargado(newSillon.getIdEncargado());
            aux.setEstado(newSillon.getEstado());
            sillonService.saveOrUpdateSillon(aux);
            return new ResponseEntity<Sillon>(aux, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSillon(@PathVariable final Long id) {
        final Sillon sillon = sillonService.findSillonById(id);
        if(sillon!=null){
            sillonService.delete(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

}