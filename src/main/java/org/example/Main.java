package org.example;

import org.example.clases.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {
    public static void main(String[] args) {
        //Creamos los clientes
        CodigoPostal cod1 = new CodigoPostal(23470,"Cazorla");
        Direccion dire1 = new Direccion("Calle","Virgen de la Cabeza",cod1);
        Cliente cliente1 = new Cliente("Mateo","López Gutiérrez",dire1,"mlp23@gmail.com");

        CodigoPostal cod2 = new CodigoPostal(230008,"Jaén");
        Direccion dire2 = new Direccion("Avenida","Andalucía",cod2);
        Cliente cliente2 = new Cliente("Andrea","Castilla Cocera",dire2,"acascoc098@g.educaand.es");

        Direccion dire3 = new Direccion("Plaza","e la Corredera",cod1);
        Cliente cliente3 = new Cliente("Juan","Pérez Sánchez",dire3,"mlp23@gmail.com");
        //Probamos que ha salido bien
        //System.out.println(cliente3);

        //Ahora generamos las reservas
        Reserva reserva1 = new Reserva(123,"23/07/2023","27/07/2023","20:00",cliente1);
        Reserva reserva2 = new Reserva(98,"10/05/2023","20/05/2023","18:45",cliente3);
        Reserva reserva3 = new Reserva(133,"04/07/2023","08/07/2023","17:15",cliente1);
        Reserva reserva4 = new Reserva(245,"05/11/2023","10/11/2023","10:15",cliente2);
        Reserva reserva5 = new Reserva(33,"04/02/2023","08/02/2023","11:00",cliente2);
        Reserva reserva6 = new Reserva(150,"06/08/2023","12/08/2023","14:30",cliente2);
        Reserva reserva7 = new Reserva(115,"24/06/2023","29/06/2023","13:45",cliente2);
        Reserva reserva8 = new Reserva(169,"30/09/2023","03/10/2023","17:00",cliente3);
        Reserva reserva9 = new Reserva(220,"04/10/2023","12/10/2023","17:30",cliente1);
        Reserva reserva10 = new Reserva(134,"05/06/2023","07/06/2023","19:15",cliente3);
        //Probamos que ha salido bien
        //System.out.println(reserva4);
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(reserva1);
        reservas.add(reserva2);
        reservas.add(reserva3);
        reservas.add(reserva4);
        reservas.add(reserva5);
        reservas.add(reserva6);
        reservas.add(reserva7);
        reservas.add(reserva8);
        reservas.add(reserva9);
        reservas.add(reserva10);

        //Serializamos las reservas con el método que hemos implementado
        serializaReservas("reservas.dat",reservas);
        //Marshalling a las reservas
        marshaller("reservas.dat");
        //UnMarshalling a las reservas
        unMarshaller("reservas.xml");

        //Por último creamos las facturas
        Factura factura1 = new Factura(2,20,"individual",20.00,reserva5,cliente2);
        Factura factura2 = new Factura(33,9,"doble",40.00,reserva2,cliente3);
        Factura factura3 = new Factura(67,330,"suite",100.00,reserva4,cliente2);
        Factura factura4 = new Factura(8,22,"doble",20.00,reserva8,cliente3);
        Factura factura5 = new Factura(234,25,"individual",20.00,reserva3,cliente1);
        Factura factura6 = new Factura(66,206,"individual",20.00,reserva7,cliente2);
        Factura factura7 = new Factura(223,17,"individual",20.00,reserva9,cliente1);
        Factura factura8 = new Factura(156,24,"doble",20.00,reserva10,cliente3);
        Factura factura9 = new Factura(20,53,"individual",20.00,reserva1,cliente1);
        Factura factura10 = new Factura(12,25,"suite",100.00,reserva6,cliente2);
        //Probamos que ha salido bien
        //System.out.println(factura4);

    }

    private static void serializaReservas(String archivo, List<Reserva> listareservas){
        try (ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream(archivo))){
            ops.writeObject(listareservas);
            System.out.println("Se han serializado las reservas en el archivo " + archivo);
        } catch (IOException e) {
            System.err.println("Error al serializar los datos: " + e.getMessage());
        }
    }

    private static void marshaller(String archivo){
        List<Reserva> lisrese = new ArrayList<>();

        //Deserializamos las reservas para que sea más fácil
        try (ObjectInputStream ips = new ObjectInputStream(new FileInputStream(archivo))){
            lisrese = (List<Reserva>) ips.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
        }

        JAXBContext jContext;

        try {
            jContext = JAXBContext.newInstance(lisrese.getClass());
            Marshaller jMarshaller = jContext.createMarshaller();
            jMarshaller.setProperty(jMarshaller.JAXB_FORMATTED_OUTPUT,true);
            jMarshaller.marshal(lisrese, new File("reservas.xml"));
        } catch (JAXBException e) {
            System.err.println("Error al crear el mashall, némro de error: " + e.getErrorCode());
        }
    }

    private static void unMarshaller(String archivoxml){
        List<Reserva> rList = new ArrayList<>();
        JAXBContext uJaxbContext;

        try {
            uJaxbContext = JAXBContext.newInstance(rList.getClass());
            Unmarshaller jUnmarshaller = uJaxbContext.createUnmarshaller();
            Object object = jUnmarshaller.unmarshal(new File(archivoxml));
            rList = (List<Reserva>) object;
            System.out.println();
        } catch (JAXBException e) {
            System.err.println("Error al hacer unmarshalling: " + e.getMessage());
        }
    }
}