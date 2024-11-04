package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Cita.CrearCitaDTO;
import co.edu.uniquindio.peluqueria.dto.Cita.EditarCitaDTO;
import co.edu.uniquindio.peluqueria.dto.Cita.InformacionCitaDTO;
import co.edu.uniquindio.peluqueria.exceptions.CitaException;
import co.edu.uniquindio.peluqueria.model.documents.Cita;
import co.edu.uniquindio.peluqueria.repository.CitaRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitaServicioImpl implements CitaServicio {

    @Autowired
    private CitaRepo citaRepo;

    @Override
    public void crearCita(CrearCitaDTO citaDTO) throws CitaException {
        // Crear una instancia de Cita utilizando el DTO
        Cita cita = new Cita();
        cita.setEmpleadoId(citaDTO.empleadoId());
        cita.setClienteId(citaDTO.clienteId());
        cita.setFechaHora(citaDTO.fechaHora());
        cita.setServicioId(citaDTO.servicioId());
        cita.setEstado(citaDTO.estado());

        // Guardar la cita en la base de datos
        citaRepo.save(cita);
    }

    @Override
    public void editarCita(String id, EditarCitaDTO citaDTO) throws CitaException {
        // Buscar la cita por ID
        Optional<Cita> citaOptional = citaRepo.findById(id);

        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();

            // Actualizar los campos de la cita
            cita.setFechaHora(citaDTO.fechaHora());
            cita.setEstado(citaDTO.estado());

            // Guardar los cambios
            citaRepo.save(cita);

        } else {
            throw new CitaException("No se encontró la cita con el ID: " + id);
        }
    }

    @Override
    public void eliminarCita(String id) throws CitaException {
        if (!citaRepo.existsById(id)) {
            throw new CitaException("No se encontró la cita con el ID: " + id);
        }
        citaRepo.deleteById(id);
    }

    @Override
    public InformacionCitaDTO obtenerCitaPorId(String id) throws CitaException {
        Optional<Cita> citaOptional = citaRepo.findById(id);
        if (citaOptional.isEmpty()) {
            throw new CitaException("No se encontró la cita con el ID: " + id);
        }

        // Convertir Cita a InformacionCitaDTO
        Cita cita = citaOptional.get();
        return new InformacionCitaDTO(
                cita.getId(),
                cita.getEmpleadoId(),
                cita.getClienteId(),
                cita.getFechaHora(),
                cita.getServicioId(),
                cita.getEstado()
        );
    }

    @Override
    public List<InformacionCitaDTO> obtenerTodasLasCitas() throws CitaException {
        return citaRepo.findAll().stream()
                .map(cita -> new InformacionCitaDTO(
                        cita.getId(),
                        cita.getEmpleadoId(),
                        cita.getClienteId(),
                        cita.getFechaHora(),
                        cita.getServicioId(),
                        cita.getEstado()
                ))
                .collect(Collectors.toList());
    }
}
