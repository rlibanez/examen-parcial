package es.cic.curso.ejerc04.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.cic.curso.ejerc04.model.Pelicula;

@Service
public class PeliculaService {

    private List<Pelicula> peliculaRepository = new ArrayList<>();

    public List<Pelicula> listar() {
        return peliculaRepository;
    }

    public Pelicula leer(long id) {
        Pelicula pelicula = null;
        int indice = 0;
        while (indice < peliculaRepository.size() && pelicula == null) {
            if (peliculaRepository.get(indice).getId() == id) {
                pelicula = peliculaRepository.get(indice);
            }
            indice++;
        }
        return pelicula;
    }

    public Pelicula agregar(Pelicula pelicula) {
        peliculaRepository.add(pelicula);
        return pelicula;
    }

    public void actualizar(Pelicula pelicula) {
        peliculaRepository.add(pelicula);
    }

}
