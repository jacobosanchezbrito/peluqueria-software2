package co.edu.uniquindio.peluqueria.dto.Empleado;

import co.edu.uniquindio.peluqueria.model.enums.EspecialidadEmpleado;

import java.util.List;

public record ObtenerEmpleadoDTO(
        String id,

        String nombre,

        String telefono,

        List<HorarioDTO> horario,

        EspecialidadEmpleado especialidad
) {
}