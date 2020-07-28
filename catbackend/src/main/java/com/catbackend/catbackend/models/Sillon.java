package com.catbackend.catbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import antlr.collections.List;

@Entity
public class Sillon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idEncargado;
    private String estado;

    public Sillon(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
}