package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.example.clases.Reserva;
import org.example.clases.Reservas;

public class Unmarshaller {
    public static void main(String[] args){
        Reservas rList = new Reservas();
        JAXBContext uJaxbContext;

        try {
            uJaxbContext = JAXBContext.newInstance(rList.getClass());
            javax.xml.bind.Unmarshaller jUnmarshaller = uJaxbContext.createUnmarshaller();
            Object object = jUnmarshaller.unmarshal(new File("reservas.xml"));
            rList = (Reservas) object;
            System.out.println();
        } catch (JAXBException e) {
            System.err.println("Error al hacer unmarshalling: " + e.getMessage());
        }
    }
}
