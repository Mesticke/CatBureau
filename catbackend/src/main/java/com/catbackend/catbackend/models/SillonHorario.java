package com.catbackend.catbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SillonHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idSillon;
    private String idHorario;

    public SillonHorario(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdSillon() {
        return idSillon;
    }

    public void setIdSillon(String idSillon) {
        this.idSillon = idSillon;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }
}