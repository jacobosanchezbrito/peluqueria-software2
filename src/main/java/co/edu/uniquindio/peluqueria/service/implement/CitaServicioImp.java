package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.model.documents.Cita;
import co.edu.uniquindio.peluqueria.repository.CitaRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CitaServicioImp implements CitaServicio {

    private CitaRepo citaRepo;

    @Override
    public Cita crearCita(Cita cita) {
        return citaRepo.save(cita);
    }

    @Override
    public Cita modificarCita(Integer id, Cita citaModificada) {
        Cita cita = citaRepo.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setFecha(citaModificada.getFecha());
        cita.setHora(citaModificada.getHora());
        cita.setEmpleado(citaModificada.getEmpleado());
        cita.setServicio(citaModificada.getServicio());
        cita.setEstado(citaModificada.getEstado());
        return citaRepo.save(cita);
    }

    @Override
    public void eliminarCita(Integer id) {
        citaRepo.deleteById(id);
    }

    @Override
    public List<Cita> obtenerCitas() {
        return citaRepo.findAll();
    }

    @Override
    public Cita obtenerCitaPorId(Integer id) {
        return citaRepo.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

}