# PRUEBA PRÁCTICA

Crear un programa para intercambio de información en XML de clientes y reservas de hotel,generamos 3 clientes, 10 reservas y a partir de ellos generamos 10 facturas.
Hay que hacer 3 programas, uno que serialice las reservas a “reservas.dat”, otro que lea “reservas.dat” y con los datos en memoria haga el marshalling de las reservas a XML
(incluyendo el cliente y su información, así como de la reserva) y otro que haga el unmarshalling de dichos objetos y los muestre por pantalla.

## CLASES:
Veamos que clases hemos creado:

### Cliente

```java
/**
 * Clase Cliente
 * @author acascoc098 Andrea Castilla Cocera
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private Direccion direccion;
    private String email;
```

### CodigoPostal

```java
public class CodigoPostal {
    private int codigo;
    private String ciudad;
```

### Direccion

```java
public class Direccion {
    private String tipovia;
    private String denominacion;
    private CodigoPostal codpos;
```

### Factura

```java
public class Factura {
    private int numfactura;
    private int numhabitacion;
    private String tipohabitacion;
    private double importe;
    private Reserva reserva;
    private Cliente cliente;
```

### Reserva

```java
public class Reserva {

    private int numreserva;
    private String fechaentrada;
    private String fechasalida;
    private String horaentrada;
    private Cliente cliente;
```

### Reservas

```java
    private List<Reserva> reservas;
```

También contamos con unas clases para marshalling y unmarshalling:

#### Marshallign.java

```java
public class Marshaller {
    private Object JAXB_FORMATTED_OUTPUT;

    public static void main(String[] args){
        List<Reserva> lisrese = new ArrayList<>();

        //Deserializamos las reservas para que sea más fácil
        try (ObjectInputStream ips = new ObjectInputStream(new FileInputStream("reservas.dat"))){
            lisrese = (List<Reserva>) ips.readObject();
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
            System.err.println("Error al crear el mashall, némro de error: " + e.getErrorCode());
        }
    }
}
```

#### Unmarshalling

```java
public class Unmarshaller {
    public static void main(String[] args){
        List<Reserva> rList = new ArrayList<>();
        JAXBContext uJaxbContext;

        try {
            uJaxbContext = JAXBContext.newInstance(rList.getClass());
            javax.xml.bind.Unmarshaller jUnmarshaller = uJaxbContext.createUnmarshaller();
            Object object = jUnmarshaller.unmarshal(new File("reservas.xml"));
            rList = (List<Reserva>) object;
            System.out.println();
        } catch (JAXBException e) {
            System.err.println("Error al hacer unmarshalling: " + e.getMessage());
        }
    }
}
```