package org.example.clases;

public class Direccion {
    private String tipovia;
    private String denominacion;
    private CodigoPostal codpos;

    public Direccion(String tipovia, String denominacion, CodigoPostal codpos) {
        this.tipovia = tipovia;
        this.denominacion = denominacion;
        this.codpos = codpos;
    }

    public String getTipovia() {
        return tipovia;
    }

    public void setTipovia(String tipovia) {
        this.tipovia = tipovia;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public CodigoPostal getCodpos() {
        return codpos;
    }

    public void setCodpos(CodigoPostal codpos) {
        this.codpos = codpos;
    }
}
