package co.edu.uniquindio.peluqueria.dto.Empleado;

import co.edu.uniquindio.peluqueria.model.enums.Dia;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record ActualizarHorarioDTO(

        @NotNull(message = "Horario no encontrado")
        String id,

        @NotNull(message = "El día es requerido")
        Dia dia,

        @NotNull(message = "La hora de entrada es requerida")
        LocalTime horaEntrada,

        @NotNull(message = "La hora de salida es requerida")
        LocalTime horaSalida,

        @NotNull(message = "Las horas trabajadas son requeridas")
        @Min(value = 0, message = "Las horas trabajadas no pueden ser negativas")
        int horasTrabajadas
) {
}