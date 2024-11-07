package co.edu.uniquindio.peluqueria.dto.Empleado;

import co.edu.uniquindio.peluqueria.model.enums.Dia;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record HorarioDTO(
        String id,

        Dia dia,

        LocalTime horaEntrada,

        LocalTime horaSalida,

        int horasTrabajadas
) {
}