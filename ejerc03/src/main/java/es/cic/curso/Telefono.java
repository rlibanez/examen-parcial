package es.cic.curso;

public class Telefono {

    private Teclado teclado;
    private Pantalla pantalla;
    private boolean encendido;
    private boolean enLlamada;

    public Telefono() {
    }

    public Telefono(Teclado teclado, Pantalla pantalla) {
        this.teclado = teclado;
        this.pantalla = pantalla;
    }

    public void encenderApagar() {
        if (isEncendido()) {
            this.enLlamada = false;
            this.encendido = false;
        } else {
            this.encendido = true;
        }
    }

    public void llamar() {
        if (isEncendido() && !isEnLlamada()) {
            int numero = this.teclado.getNumero();
            this.pantalla.pintar(Integer.toString(numero));
            this.enLlamada = true;
        }
    }

    public void colgar() {
        if (isEncendido() && isEnLlamada()) {
            this.enLlamada = false;
        }
    }

    ////////// Getters
    public boolean isEncendido() {
        return encendido;
    }

    public boolean isEnLlamada() {
        return enLlamada;
    }

}
