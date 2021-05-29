package com.example.aplication.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User extends Persona implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;   
    


    @NotEmpty
    private String tipoDocumento;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String username;
    private Boolean enabled;
    @NotEmpty
    private String password;
    

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


   

    public String getTipoDocumento() {
        return tipoDocumento;
    }


    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public Boolean getEnabled() {
        return enabled;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [ "+super.toString()+" email= "  + email + ", enabled=" + enabled + ", password=" + password + ", role=" + role
                + ", tipoDocumento=" + tipoDocumento + ", username=" + username + "]";
    }

}
