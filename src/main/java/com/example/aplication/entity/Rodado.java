package com.example.aplication.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rodado")
public class Rodado implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRodado;

    @NotEmpty
    private String domino;
    @NotEmpty
    private String vehiculo;

    
    public Long getIdRodado() {
        return idRodado;
    }
    public void setIdRodado(Long idRodado) {
        this.idRodado = idRodado;
    }
    public String getDomino() {
        return domino;
    }
    public void setDomino(String domino) {
        this.domino = domino;
    }
    public String getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idRodado == null) ? 0 : idRodado.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rodado other = (Rodado) obj;
        if (idRodado == null) {
            if (other.idRodado != null)
                return false;
        } else if (!idRodado.equals(other.idRodado))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Rodado [domino=" + domino + ", idRodado=" + idRodado + ", vehiculo=" + vehiculo + "]";
    }

    









}