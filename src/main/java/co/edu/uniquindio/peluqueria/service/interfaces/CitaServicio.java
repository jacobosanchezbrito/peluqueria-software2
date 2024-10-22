package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Cita.CrearCitaDTO;
import co.edu.uniquindio.peluqueria.dto.Cita.EditarCitaDTO;
import co.edu.uniquindio.peluqueria.dto.Cita.InformacionCitaDTO;
import co.edu.uniquindio.peluqueria.exceptions.CitaException;

import java.util.List;

public interface CitaServicio {

    void crearCita(CrearCitaDTO citaDTO) throws CitaException;

    void editarCita(String id, EditarCitaDTO citaDTO) throws CitaException;

    void eliminarCita(String id) throws CitaException;

    InformacionCitaDTO obtenerCitaPorId(String id) throws CitaException;

    List<InformacionCitaDTO> obtenerTodasLasCitas() throws CitaException;
}

