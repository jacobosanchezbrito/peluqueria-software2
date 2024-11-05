package co.edu.uniquindio.peluqueria.dto.Empleado;

import co.edu.uniquindio.peluqueria.model.enums.EspecialidadEmpleado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record ActualizarEmpleadoDTO(

        @NotBlank(message = "El nombre es requerido")
        @Length(max = 100, message = "El nombre debe tener un máximo de 100 caracteres")
        String nombre,

        @NotBlank(message = "El teléfono es requerido")
        @Length(max = 10, message = "El teléfono debe tener un máximo de 10 caracteres")
        String telefono,

        @NotBlank(message = "El correo es requerido")
        @Length(max = 100, message = "El correo debe tener un máximo de 100 caracteres")
        String correo, // Nuevo atributo

        @NotBlank(message = "La contraseña es requerida")
        @Length(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres")
        String contrasena, // Nuevo atributo

        @NotNull(message = "El horario es requerido")
        List<ActualizarHorarioDTO> horario,

        @NotNull(message = "La especialidad es requerida")
        EspecialidadEmpleado especialidad
) {
}
