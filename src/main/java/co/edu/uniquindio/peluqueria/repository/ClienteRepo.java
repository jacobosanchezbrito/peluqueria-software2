package co.edu.uniquindio.peluqueria.repository;

import co.edu.uniquindio.peluqueria.model.documents.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {

    // Consulta personalizada para verificar si ya existe un cliente con un teléfono específico
    boolean existsByTelefono(String telefono);

    // Consulta personalizada para verificar si ya existe un cliente con un correo específico
    boolean existsByCorreo(String correo);

    // Método para buscar un cliente por correo
    Optional<Cliente> findByCorreo(String correo);
}
