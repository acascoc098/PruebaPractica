package org.example.clases;

import java.sql.Time;
import java.util.Date;

public class Reserva {
    private int numreserva;
    private Date fechaentrada;
    private Date fechasalida;
    private String horaentrada;

    public Reserva(int numreserva, Date fechaentrada,
                   Date fechasalida, String horaentrada) {
        this.numreserva = numreserva;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.horaentrada = horaentrada;
    }

    public int getNumreserva() {
        return numreserva;
    }

    public void setNumreserva(int numreserva) {
        this.numreserva = numreserva;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(String horaentrada) {
        this.horaentrada = horaentrada;
    }
}
