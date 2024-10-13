package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.model.documents.Cita;

import java.util.List;

public interface CitaServicio {

    Cita crearCita(Cita cita);
    Cita modificarCita(Integer id, Cita cita);
    void eliminarCita(Integer id);
    List<Cita> obtenerCitas();
    Cita obtenerCitaPorId(Integer id);
}
