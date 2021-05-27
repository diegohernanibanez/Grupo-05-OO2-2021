package com.example.aplication.entity;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "permisoPeriodo")
@PrimaryKeyJoinColumn (referencedColumnName = "id_PermisoPeriodo") //id_PermisoDiario es la FK
public class PermisoPeriodo extends Permiso {


    
    @NotEmpty
    private int cantDias;

    private boolean vacaciones;
    @NotEmpty
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
    public String toString() {
        return "PermisoPeriodo [cantDias=" + cantDias + ", rodado=" + rodado + ", vacaciones=" + vacaciones + "]";
    }

    


}