package co.edu.uniquindio.peluqueria.repository;

import co.edu.uniquindio.peluqueria.model.documents.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CitaRepo extends MongoRepository<Cita, String> {

    List<Cita> findByEmpleadoId(String empleadoId);

    List<Cita> findByClienteId(String clienteId);

    boolean existsByFechaHora(LocalDateTime fechaHora);

    Optional<Cita> findById(String id);
}

