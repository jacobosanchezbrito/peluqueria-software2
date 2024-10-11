package co.edu.uniquindio.peluqueria.dto.Empleado;

import co.edu.uniquindio.peluqueria.model.enums.Dia;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CrearHorarioDTO(
        @NotNull(message = "El día es requerido")
        Dia dia,

        @NotNull(message = "La hora de entrada es requerida")
        LocalDateTime horaEntrada,

        @NotNull(message = "La hora de salida es requerida")
        LocalDateTime horaSalida,

        @NotNull(message = "Las horas trabajadas son requeridas")
        @Min(value = 0, message = "Las horas trabajadas no pueden ser negativas")
        int horasATrabajar
) {
}