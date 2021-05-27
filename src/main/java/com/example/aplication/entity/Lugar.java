package com.example.aplication.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Lugar {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) 
    private int idLugar;

    @Column(name="lugar", nullable=false, length=45)
    private String lugar;

    @Column(name="codigoPostal", nullable=false, length=8)
    private String codigoPostal;

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoPostal == null) ? 0 : codigoPostal.hashCode());
        result = prime * result + idLugar;
        result = prime * result + ((lugar == null) ? 0 : lugar.hashCode());
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
        Lugar other = (Lugar) obj;
        if (codigoPostal == null) {
            if (other.codigoPostal != null)
                return false;
        } else if (!codigoPostal.equals(other.codigoPostal))
            return false;
        if (idLugar != other.idLugar)
            return false;
        if (lugar == null) {
            if (other.lugar != null)
                return false;
        } else if (!lugar.equals(other.lugar))
            return false;
        return true;
    }

    
    
}
