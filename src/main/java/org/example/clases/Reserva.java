package org.example.clases;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * Clase Reserva
 * @author acascoc098 Andrea Castilla
 */
@XmlRootElement(name = "reserva")
@XmlAccessorType (XmlAccessType.FIELD)
public class Reserva {

    private int numreserva;
    private String fechaentrada;
    private String fechasalida;
    private String horaentrada;
    private Cliente cliente;

    public Reserva(int numreserva, String fechaentrada, String fechasalida, String horaentrada, Cliente cliente) {
        this.numreserva = numreserva;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.horaentrada = horaentrada;
        this.cliente = cliente;
    }

    public int getNumreserva() {
        return numreserva;
    }

    public void setNumreserva(int numreserva) {
        this.numreserva = numreserva;
    }

    public String getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(String horaentrada) {
        this.horaentrada = horaentrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numreserva=" + numreserva +
                ", fechaentrada='" + fechaentrada + '\'' +
                ", fechasalida='" + fechasalida + '\'' +
                ", horaentrada='" + horaentrada + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
