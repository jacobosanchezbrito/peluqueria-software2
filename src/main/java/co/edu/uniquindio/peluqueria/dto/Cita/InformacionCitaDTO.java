package co.edu.uniquindio.peluqueria.dto.Cita;

import co.edu.uniquindio.peluqueria.model.enums.EstadoCita;

import java.time.LocalDateTime;

public record InformacionCitaDTO(

        String id,
        String empleadoId,
        String clienteId,
        LocalDateTime fechaHora,
        String servicioId,
        EstadoCita estado

) {
}
