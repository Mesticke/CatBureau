package com.catbackend.catbackend.daos;

import com.catbackend.catbackend.models.Sillon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SillonRepository extends CrudRepository<Sillon,Long> {

    Iterable<Sillon> findByEstado(String estado);
    Iterable<Sillon> findByidEncargado(Long idEncargado);
}
