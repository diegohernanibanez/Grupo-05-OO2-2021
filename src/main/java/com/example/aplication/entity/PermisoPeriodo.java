package com.example.aplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "permisoperiodo")
public class PermisoPeriodo extends Permiso{

    @Column(name="cantDias", nullable=false)
    private int cantDias;

    @Column(columnDefinition="tinyint(1) default 0" , nullable = false)
    private boolean vacaciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idRodado", nullable = false)
    private Rodado rodado;

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public boolean isVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(boolean vacaciones) {
        this.vacaciones = vacaciones;
    }

    public Rodado getRodado() {
        return rodado;
    }

    public void setRodado(Rodado rodado) {
        this.rodado = rodado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + cantDias;
        result = prime * result + ((rodado == null) ? 0 : rodado.hashCode());
        result = prime * result + (vacaciones ? 1231 : 1237);
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
        PermisoPeriodo other = (PermisoPeriodo) obj;
        if (cantDias != other.cantDias)
            return false;
        if (rodado == null) {
            if (other.rodado != null)
                return false;
        } else if (!rodado.equals(other.rodado))
            return false;
        if (vacaciones != other.vacaciones)
            return false;
        return true;
    }

  

    
    
}
