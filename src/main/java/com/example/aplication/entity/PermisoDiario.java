package com.example.aplication.entity;



import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "permisoDiario")
@PrimaryKeyJoinColumn (referencedColumnName = "id_PermisoDiario") //id_PermisoDiario es la FK
public class PermisoDiario extends Permiso  {



    @NotEmpty
    private String motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "PermisoDiario [motivo=" + motivo + "]";
    }

    




}