package com.example.aplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table (name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) 
    private long id;

    @Column(name="nombre", nullable=false, length=45)
    private String nombre;

    @Column(name="apellido", nullable=false, length=45)
    private String apellido;

    
	@Column(name="dni", unique=true, nullable=false, length=8)
    private long dni;

    @Column(columnDefinition="tinyint(1) default 1" , nullable = false)
    private boolean enabled;




    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
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
