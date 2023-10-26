# PRUEBA PRÁCTICA

Crear un programa para intercambio de información en XML de clientes y reservas de hotel,generamos 3 clientes, 10 reservas y a partir de ellos generamos 10 facturas.
Hay que hacer 3 programas, uno que serialice las reservas a “reservas.dat”, otro que lea “reservas.dat” y con los datos en memoria haga el marshalling de las reservas a XML
(incluyendo el cliente y su información, así como de la reserva) y otro que haga el unmarshalling de dichos objetos y los muestre por pantalla.

```java
/**Prueba práctica 26-10-23
 * @author acascoc098 Andrea Castilla Cocera 
 */
```

## CLASES:
Veamos que clases hemos creado:

### Cliente

```java
@XmlRootElement(name = "cliente")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cliente implements Serializable {
    private String nombre;
    private String apellidos;
    private Direccion direccion;
    private String email;

```

### CodigoPostal

```java
@XmlRootElement(name = "codigoPostal")
@XmlAccessorType (XmlAccessType.FIELD)
public class CodigoPostal implements Serializable {
    private int codigo;
    private String ciudad;
```

### Direccion

```java
@XmlRootElement(name = "direccion")
@XmlAccessorType (XmlAccessType.FIELD)
public class Direccion implements Serializable {
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
public class Reserva implements Serializable {

    private int numreserva;
    private String fechaentrada;
    private String fechasalida;
    private String horaentrada;
    private Cliente cliente;
```

### Reservas

```java
public class Reservas implements Serializable {
    @XmlElement(name="reserva")
    private List<Reserva> reservas;
```

También contamos con unas clases para marshalling y unmarshalling:

#### Marshallign.java

```java
public class Marshaller {
    private static final long serialVersionUID = 6529685098267757690L;
    public static void main(String[] args){
        Reservas res = new Reservas();

        //Deserializamos las reservas para que sea más fácil
        try (ObjectInputStream ips = new ObjectInputStream(new FileInputStream("reservas.dat"))){
            Reservas re = (Reservas) ips.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
           // e.printStackTrace();
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
```

#### Unmarshalling

```java
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
```

Además, en la clase Main tenemos un método para serializar las reservas:

```java
private static void serializaReservas(String archivo, Reservas reser){
        try (ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream(archivo))){
            ops.writeObject(reser);
            System.out.println("Se han serializado las reservas en el archivo " + archivo);
        } catch (IOException e) {
            System.err.println("Error al serializar los datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
```