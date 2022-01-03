package co.com.sofka.biblioteca.Repositories;

import co.com.sofka.biblioteca.Models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioRecurso extends MongoRepository<Recurso, String> {
    List<Recurso> findByAreaTematica(String area);
    List<Recurso> findByTipo(String tipo);
    List<Recurso> findByAreaTematicaAndTipo(String area, String tipo);
}
