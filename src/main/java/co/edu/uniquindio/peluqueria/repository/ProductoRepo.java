package co.edu.uniquindio.peluqueria.repository;

import co.edu.uniquindio.peluqueria.model.documents.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends MongoRepository<Producto, String> {
}
