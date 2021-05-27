package com.example.aplication.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "permiso")
public class Permiso {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) 
    protected int id;

    protected Persona pedido;

    @Column(name="fecha", nullable=false)
    protected LocalDate fecha;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="permiso")
    protected Set<Lugar> desdeHasta = new HashSet<Lugar>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        result = prime * result + ((desdeHasta == null) ? 0 : desdeHasta.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + id;
        result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
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
        if (desdeHasta == null) {
            if (other.desdeHasta != null)
                return false;
        } else if (!desdeHasta.equals(other.desdeHasta))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (id != other.id)
            return false;
        if (pedido == null) {
            if (other.pedido != null)
                return false;
        } else if (!pedido.equals(other.pedido))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Permiso [desdeHasta=" + desdeHasta + ", fecha=" + fecha + ", id=" + id + ", pedido=" + pedido + "]";
    }

    

    
}
