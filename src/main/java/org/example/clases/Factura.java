package org.example.clases;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase Factura
 * @author acascoc098 Andrea Castilla Cocera
 */

public class Factura {
    private int numfactura;
    private int numhabitacion;
    private String tipohabitacion;
    private double importe;
    private Reserva reserva;
    private Cliente cliente;

    public Factura(int numfactura, int numhabitacion,
                   String tipohabitacion, double importe,
                   Reserva reserva, Cliente cliente) {
        this.numfactura = numfactura;
        this.numhabitacion = numhabitacion;
        this.tipohabitacion = tipohabitacion;
        this.importe = importe;
        this.reserva = reserva;
        this.cliente = cliente;
    }

    public int getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(int numfactura) {
        this.numfactura = numfactura;
    }

    public int getNumhabitacion() {
        return numhabitacion;
    }

    public void setNumhabitacion(int numhabitacion) {
        this.numhabitacion = numhabitacion;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numfactura=" + numfactura +
                ", numhabitacion=" + numhabitacion +
                ", tipohabitacion='" + tipohabitacion + '\'' +
                ", importe=" + importe +
                ", reserva=" + reserva +
                ", cliente=" + cliente +
                '}';
    }
}
