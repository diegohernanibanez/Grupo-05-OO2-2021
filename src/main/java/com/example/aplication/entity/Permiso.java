package com.example.aplication.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "permiso")
public abstract class Permiso {

    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) 
    protected int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    protected Persona pedido;

    @Column(name="fecha", nullable=false)
    protected LocalDate fecha;

    @ManyToMany(mappedBy = "permisos")
    protected Set<Lugar> desdeHasta = new HashSet<Lugar>();
    


    public int getId() {
        return id;
    }

    public Set<Lugar> getDesdeHasta() {
        return desdeHasta;
    }

    public void setDesdeHasta(Set<Lugar> desdeHasta) {
        this.desdeHasta = desdeHasta;
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

     
    @Override
    public String toString() {
        return "Permiso [fecha=" + fecha + ", id=" + id + ", lugares=" + desdeHasta + ", pedido=" + pedido + "]";
    }

   


    
}
