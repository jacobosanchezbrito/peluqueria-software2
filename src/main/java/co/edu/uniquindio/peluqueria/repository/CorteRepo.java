package co.edu.uniquindio.peluqueria.repository;

import co.edu.uniquindio.peluqueria.model.documents.Corte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CorteRepo extends MongoRepository<Corte, String> {
    boolean existsById(String id);
    Optional<Corte> findById(String id);
}