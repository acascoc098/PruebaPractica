package org.example.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reservas")
@XmlAccessorType (XmlAccessType.FIELD)
public class Reservas implements Serializable {
    @XmlElement(name="reserva")
    private List<Reserva> reservas;

    public Reservas() {
        reservas = new ArrayList<>();
    }

    public Reservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Reservas [reservas=" + getReservas() + "]";
    }

}
