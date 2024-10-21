package co.edu.uniquindio.peluqueria.repository;

import co.edu.uniquindio.peluqueria.model.documents.Servicios;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ServiciosRepo  extends MongoRepository<Servicios, String> {
    boolean existsById(String id);
    Optional<Servicios> findById(String id);
}