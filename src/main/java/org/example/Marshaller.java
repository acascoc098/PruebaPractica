package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.example.clases.Reserva;

public class Marshaller {
    private Object JAXB_FORMATTED_OUTPUT;

    public static void main(String[] args){
        List<Reserva> lisrese = new ArrayList<>();

        //Deserializamos las reservas para que sea más fácil
        try (ObjectInputStream ips = new ObjectInputStream(new FileInputStream("reservas.dat"))){
            while (true) {
                try{
                    Reserva reser = (Reserva) ips.readObject();
                    lisrese.add(reser);
                }catch(EOFException e){
                    System.err.println("Error al leer las reservas: " + e.getMessage());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
        }

        JAXBContext jContext;

        try {
            jContext = JAXBContext.newInstance(lisrese.getClass());
            javax.xml.bind.Marshaller jMarshaller = jContext.createMarshaller();
            jMarshaller.setProperty(jMarshaller.JAXB_FORMATTED_OUTPUT,true);
            jMarshaller.marshal(lisrese, new File("reservas.xml"));
        } catch (JAXBException e) {
            System.err.println("Error al crear el mashall, número de error: " + e.getErrorCode());
        }
    }
}
