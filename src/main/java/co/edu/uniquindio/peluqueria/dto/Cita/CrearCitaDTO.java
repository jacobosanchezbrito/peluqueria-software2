package co.edu.uniquindio.peluqueria.dto.Cita;

import co.edu.uniquindio.peluqueria.model.enums.EstadoCita;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CrearCitaDTO(

        @NotNull(message = "El ID del empleado es requerido")
        String empleadoId,

        @NotNull(message = "El ID del cliente es requerido")
        String clienteId,

        @NotNull(message = "La fecha y hora es requerida")
        LocalDateTime fechaHora,

        @NotNull(message = "El ID del servicio es requerido")
        String servicioId,

        @NotNull(message = "El estado de la cita es requerido")
        EstadoCita estado
) {}