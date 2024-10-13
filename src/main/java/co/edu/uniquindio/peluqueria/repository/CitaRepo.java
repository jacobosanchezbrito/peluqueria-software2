package co.edu.uniquindio.peluqueria.repository;

import co.edu.uniquindio.peluqueria.model.documents.Cita;
import co.edu.uniquindio.peluqueria.model.documents.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepo extends MongoRepository<Cita, Integer> {
    List<Cita> findByCliente(Empleado empleado);
    List<Cita> findByFecha(LocalDate fecha);
}

