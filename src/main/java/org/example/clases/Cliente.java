package org.example.clases;
import java.io.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase Cliente
 * @author acascoc098 Andrea Castilla Cocera
 */

@XmlRootElement(name = "cliente")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cliente implements Serializable {
    private String nombre;
    private String apellidos;
    private Direccion direccion;
    private String email;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos,
                   Direccion direccion, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion=" + direccion +
                ", email='" + email + '\'' +
                '}';
    }
}
