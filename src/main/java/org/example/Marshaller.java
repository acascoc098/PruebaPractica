package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.example.clases.Reserva;
import org.example.clases.Reservas;

public class Marshaller {
    public static void main(String[] args){
        Reservas res = new Reservas();

        //Deserializamos las reservas para que sea más fácil
        try (ObjectInputStream ips = new ObjectInputStream(new FileInputStream("reservas.dat"))){
            Reservas re = (Reservas) ips.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }

        JAXBContext jContext;

        try {
            jContext = JAXBContext.newInstance(res.getClass());
            javax.xml.bind.Marshaller jMarshaller = jContext.createMarshaller();
            jMarshaller.setProperty(jMarshaller.JAXB_FORMATTED_OUTPUT,true);
            jMarshaller.marshal(res, new File("reservas.xml"));
        } catch (JAXBException e) {
            System.err.println("Error al crear el mashall, número de error: " + e.getErrorCode());
            e.printStackTrace();
        }
    }
}
