package co.edu.uniquindio.peluqueria.dto.Cita;

import java.time.LocalDate;
import java.time.LocalTime;

public record EditarCitaDTO() {

    private static Integer idCita;

    private static LocalDate fecha;

    private static LocalTime hora;

    private static Integer idEmpleado;

    private static Integer idServicio;

    public static Integer getIdCita() {
        return idCita;
    }

    public static void setIdCita(Integer idCita) {
        EditarCitaDTO.idCita = idCita;
    }

    public static LocalDate getFecha() {
        return fecha;
    }

    public static void setFecha(LocalDate fecha) {
        EditarCitaDTO.fecha = fecha;
    }

    public static LocalTime getHora() {
        return hora;
    }

    public static void setHora(LocalTime hora) {
        EditarCitaDTO.hora = hora;
    }

    public static Integer getIdEmpleado() {
        return idEmpleado;
    }

    public static void setIdEmpleado(Integer idEmpleado) {
        EditarCitaDTO.idEmpleado = idEmpleado;
    }

    public static Integer getIdServicio() {
        return idServicio;
    }

    public static void setIdServicio(Integer idServicio) {
        EditarCitaDTO.idServicio = idServicio;
    }
}
