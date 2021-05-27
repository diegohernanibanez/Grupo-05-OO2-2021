package com.example.aplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) 
    private int id;

    @Column(name="nombre", nullable=false, length=45)
    private String nombre;

    @Column(name="apellido", nullable=false, length=45)
    private String apellido;

    
	@Column(name="dni", unique=true, nullable=false, length=8)
    private long dni;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public long getDni() {
        return dni;
    }


    public void setDni(long dni) {
        this.dni = dni;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + (int) (dni ^ (dni >>> 32));
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        Persona other = (Persona) obj;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (dni != other.dni)
            return false;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Persona [apellido=" + apellido + ", dni=" + dni + ", id=" + id + ", nombre=" + nombre + "]";
    }

    

    
}
