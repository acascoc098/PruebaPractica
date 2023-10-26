package org.example;

import org.example.clases.Cliente;
import org.example.clases.CodigoPostal;
import org.example.clases.Direccion;

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

    }
}