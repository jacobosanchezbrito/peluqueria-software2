package co.edu.uniquindio.peluqueria.dto.Empleado;

import co.edu.uniquindio.peluqueria.model.enums.Dia;

import java.time.LocalDateTime;

public record HorarioDTO(
        String id,

        Dia dia,

        LocalDateTime horaEntrada,

        LocalDateTime horaSalida,

        int horasTrabajadas
) {
}