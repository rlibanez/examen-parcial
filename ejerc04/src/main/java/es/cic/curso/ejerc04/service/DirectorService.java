package es.cic.curso.ejerc04.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.cic.curso.ejerc04.model.Director;

@Service
public class DirectorService {

    private List<Director> directorRepository = new ArrayList<>();

    public List<Director> listar() {
        return directorRepository;
    }

    public Director leer(long id) {
        Director director = null;
        int indice = 0;
        while (indice < directorRepository.size() && director == null) {
            if (directorRepository.get(indice).getId() == id) {
                director = directorRepository.get(indice);
            }
            indice++;
        }
        return director;
    }

    public Director agregar(Director director) {
        directorRepository.add(director);
        return director;
    }

    public void actualizar(Director director) {
        directorRepository.add(director);
    }

}
