package com.catbackend.catbackend.services;

import com.catbackend.catbackend.daos.SillonRepository;
import com.catbackend.catbackend.models.Sillon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SillonService")
public class SillonService {
    @Autowired
    private SillonRepository sillonRepository;

    public Sillon saveOrUpdateSillon(Sillon sillon){
        return sillonRepository.save(sillon);
    }

    public Sillon findSillonById(Long id){
        return sillonRepository.findById(id).orElse(null);
    }

    public Iterable<Sillon> listAll(){
        return sillonRepository.findAll();
    }

    public Iterable<Sillon> findSillonByState(String estado){
        return sillonRepository.findByEstado(estado);
    }

    public Iterable<Sillon> findSillonByEncargado(Long idEncargado){
        return sillonRepository.findByidEncargado(idEncargado);
    }

    public void delete(Long id){
        sillonRepository.deleteById(id);
    }
}
