package es.cic.curso;

// Suponemos que el Teclado es independiente de la Pantalla y que no pertenece a esta
public class Teclado {

    private int numero;

    public Teclado() {
    }

    ////////// Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
