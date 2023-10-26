package org.example.clases;

/**
 * Clase del Código Postal
 * @author acascoc098 Andrea Castilla Cocera
 */
public class CodigoPostal {
    private int codigo;
    private String ciudad;

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
