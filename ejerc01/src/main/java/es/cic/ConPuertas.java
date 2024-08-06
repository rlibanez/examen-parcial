package es.cic;

public interface ConPuertas {

    // Solo abrir, no puede cerrar
    void abrir();

    // Solo cerrar, no puede abrir
    void cerrar();

    // Un solo botón que conmuta el estado
    void commutar();

}
