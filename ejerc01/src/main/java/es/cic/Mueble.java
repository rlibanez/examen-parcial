package es.cic;

// Clase Abstracta???
// Se pueden crear objetos de tipo Mueble a secas???
public class Mueble {

    private String nombre;

    public Mueble() {
    }

    public Mueble(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
