package org.example.clases;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase del Código Postal
 * @author acascoc098 Andrea Castilla Cocera
 */

@XmlRootElement(name = "codigoPostal")
@XmlAccessorType (XmlAccessType.FIELD)
public class CodigoPostal implements Serializable {
    private int codigo;
    private String ciudad;

    public CodigoPostal() {
    }

    public CodigoPostal(int codigo, String ciudad) {
        this.codigo = codigo;
        this.ciudad = ciudad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
