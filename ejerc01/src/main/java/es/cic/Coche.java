package es.cic;

public class Coche implements ConPuertas {

    private boolean cocheAbierto;

    public Coche() {
    }

    @Override
    public void abrir() {
        if (!isCocheAbierto()) {
            this.cocheAbierto = true;
        }
    }

    @Override
    public void cerrar() {
        if (isCocheAbierto()) {
            this.cocheAbierto = false;
        }
    }

    @Override
    public void commutar() {
        if (isCocheAbierto()) {
            this.cocheAbierto = false;
        } else {
            this.cocheAbierto = true;
        }
    }

    public boolean isCocheAbierto() {
        return cocheAbierto;
    }

}
