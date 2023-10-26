package org.example.clases;

import java.sql.Time;
import java.util.Date;

public class Reserva {
    private int numreserva;
    private String fechaentrada;
    private String fechasalida;
    private String horaentrada;

    public Reserva(int numreserva, String fechaentrada,
                   String fechasalida, String horaentrada) {
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

    @Override
    public String toString() {
        return "Reserva{" +
                "numreserva=" + numreserva +
                ", fechaentrada='" + fechaentrada + '\'' +
                ", fechasalida='" + fechasalida + '\'' +
                ", horaentrada='" + horaentrada + '\'' +
                '}';
    }
}
