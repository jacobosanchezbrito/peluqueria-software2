package co.edu.uniquindio.peluqueria.repository;

import co.edu.uniquindio.peluqueria.model.documents.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmpleadoRepo extends MongoRepository<Empleado, String> {
    // Método para verificar si ya existe un empleado con la misma cédula
    boolean existsByCedula(String cedula);

    // Método para verificar si ya existe un empleado con el mismo teléfono
    boolean existsByTelefono(String telefono);

    // Método para buscar un empleado por ID
    Optional<Empleado> findById(String id);

    // Método para buscar un empleado por correo
    Optional<Empleado> findByCorreo(String correo);
}
