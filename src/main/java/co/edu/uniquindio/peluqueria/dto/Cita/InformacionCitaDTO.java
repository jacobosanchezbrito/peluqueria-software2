package co.edu.uniquindio.peluqueria.dto.Cita;

import java.time.LocalDate;
import java.time.LocalTime;

public record InformacionCitaDTO() {

    private static Integer idCita;

    private static LocalDate fecha;

    private static LocalTime hora;

    private static String nombreCliente;

    private static String nombreEmpleado;

    private static String nombreServicio;
}
