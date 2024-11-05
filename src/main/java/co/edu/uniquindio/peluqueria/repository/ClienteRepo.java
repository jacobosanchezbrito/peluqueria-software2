package co.edu.uniquindio.peluqueria.repository;


import co.edu.uniquindio.peluqueria.model.documents.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {

    // Consulta personalizada para verificar si ya existe un cliente con un teléfono específico
    boolean existsByTelefono(String telefono);

    boolean existsByCorreo(String correo);
}
