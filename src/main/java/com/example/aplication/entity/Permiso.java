package com.example.aplication.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "permiso")
@Inheritance(strategy =  InheritanceType.JOINED)
public class Permiso implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermiso;

    @NotEmpty
    private Persona pedido;
    @NotEmpty
    private LocalDate fecha;
    @NotEmpty
    Set <Lugar> desdeHasta;
    public Long getIdPermiso() {
        return idPermiso;
    }
    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }
    public Persona getPedido() {
        return pedido;
    }
    public void setPedido(Persona pedido) {
        this.pedido = pedido;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Set<Lugar> getDesdeHasta() {
        return desdeHasta;
    }
    public void setDesdeHasta(Set<Lugar> desdeHasta) {
        this.desdeHasta = desdeHasta;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPermiso == null) ? 0 : idPermiso.hashCode());
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
        Permiso other = (Permiso) obj;
        if (idPermiso == null) {
            if (other.idPermiso != null)
                return false;
        } else if (!idPermiso.equals(other.idPermiso))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Permiso [desdeHasta=" + desdeHasta + ", fecha=" + fecha + ", idPermiso=" + idPermiso + ", pedido="
                + pedido + "]";
    }

    
   
    


}