package com.example.aplication.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "lugar")
public class Lugar implements Serializable {

    /**
     * 
     */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLugar;

    @NotEmpty
    String lugar;
    @NotEmpty
    String codigoPostal;
    public Long getIdLugar() {
        return idLugar;
    }
    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    @Override
    public String toString() {
        return "Lugar [codigoPostal=" + codigoPostal + ", idLugar=" + idLugar + ", lugar=" + lugar + "]";
    }


    

}