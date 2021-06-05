package com.example.aplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table (name = "lugar")
public class Lugar {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) 
    private long idLugar;

    @Column(name="lugar", nullable=false, length=45)
    private String lugar;

    @Column(name="codigoPostal", nullable=false, length=8)
    private String codigoPostal;



    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "desdeHasta") 
    protected Set<Permiso> permisos = new HashSet<Permiso>();

    public long getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(long idLugar) {
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

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "Lugar [codigoPostal=" + codigoPostal + ", idLugar=" + idLugar + ", lugar=" + lugar + ", permisos="
                + permisos + "]";
    }

 
    
    
}
