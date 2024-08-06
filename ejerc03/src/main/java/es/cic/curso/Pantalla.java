package es.cic.curso;

public class Pantalla {

    private String contenido;

    public Pantalla() {
    }

    public void pintar(String texto) {
        this.contenido = texto;
    }

    ////////// Getters y Setters
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
