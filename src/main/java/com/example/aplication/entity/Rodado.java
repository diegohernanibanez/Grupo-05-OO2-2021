package com.example.aplication.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Rodado {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idRodado;

    @Column(name="dominio", nullable=false)
    private String dominio;

    @Column(name="vehiculo", nullable=false)
    private String vehiculo;

    public int getIdRodado() {
        return idRodado;
    }

    public void setIdRodado(int idRodado) {
        this.idRodado = idRodado;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Rodado [dominio=" + dominio + ", idRodado=" + idRodado + ", vehiculo=" + vehiculo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
        result = prime * result + idRodado;
        result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
        if (dominio == null) {
            if (other.dominio != null)
                return false;
        } else if (!dominio.equals(other.dominio))
            return false;
        if (idRodado != other.idRodado)
            return false;
        if (vehiculo == null) {
            if (other.vehiculo != null)
                return false;
        } else if (!vehiculo.equals(other.vehiculo))
            return false;
        return true;
    }

    
    
}
