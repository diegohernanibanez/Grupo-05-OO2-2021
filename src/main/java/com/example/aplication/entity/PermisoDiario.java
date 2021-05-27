package com.example.aplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "permisodiario")
public class PermisoDiario extends Permiso {

    @Column(name="motivo", nullable=false, length = 45)
    private String motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PermisoDiario other = (PermisoDiario) obj;
        if (motivo == null) {
            if (other.motivo != null)
                return false;
        } else if (!motivo.equals(other.motivo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PermisoDiario [motivo=" + motivo + "]";
    }

    
    
}
