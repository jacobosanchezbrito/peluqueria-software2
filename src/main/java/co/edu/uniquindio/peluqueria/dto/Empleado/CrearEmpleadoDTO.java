package co.edu.uniquindio.peluqueria.dto.Empleado;

import co.edu.uniquindio.peluqueria.model.enums.EspecialidadEmpleado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CrearEmpleadoDTO(

        @NotBlank(message = "La cédula es requerida")
        @Length(max = 10, message = "La cédula debe tener un máximo de 10 caracteres")
        @Pattern(regexp = "\\d+", message = "La cédula solo debe contener números")//La expresión regular \\d+ en @Pattern asegura que la cédula solo contenga dígitos
        String cedula,

        @NotBlank(message = "El nombre es requerido")
        @Length(max = 100, message = "El nombre debe tener un máximo de 100 caracteres")
        String nombre,

        @NotBlank(message = "El teléfono es requerido")
        @Length(max = 10, message = "El teléfono debe tener un máximo de 10 caracteres")
        String telefono,

        @NotNull(message = "El horario es requerido")
        List<CrearHorarioDTO> horario,

        @NotNull(message = "La especialidad es requerida")
        EspecialidadEmpleado especialidad
) {
}