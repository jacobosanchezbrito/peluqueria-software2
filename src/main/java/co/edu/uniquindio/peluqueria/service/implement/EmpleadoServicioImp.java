package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Empleado.*;
import co.edu.uniquindio.peluqueria.exceptions.EmpleadoException;
import co.edu.uniquindio.peluqueria.model.documents.Empleado;
import co.edu.uniquindio.peluqueria.model.documents.Horario;
import co.edu.uniquindio.peluqueria.repository.EmpleadoRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.EmpleadoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpleadoServicioImp implements EmpleadoServicio {

    @Autowired
    private EmpleadoRepo empleadoRepo;

    @Override
    public void crearEmpleado(CrearEmpleadoDTO empleadoDTO) throws EmpleadoException {
        // Validaciones previas (ejemplo: verificar si ya existe un empleado con el mismo nombre o teléfono)
        if (empleadoRepo.existsByCedula(empleadoDTO.cedula())) {
            throw new EmpleadoException("Ya existe un empleado con el nombre: " + empleadoDTO.nombre());
        }

        if (empleadoRepo.existsByTelefono(empleadoDTO.telefono())) {
            throw new EmpleadoException("Ya existe un empleado con el teléfono: " + empleadoDTO.telefono());
        }

        // Crear instancia de Empleado usando el DTO
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.nombre());
        empleado.setTelefono(empleadoDTO.telefono());
        empleado.setEspecialidad(empleadoDTO.especialidad());

        // Convertir la lista de CrearHorarioDTO a Horario y asignarlo al empleado
        List<Horario> horarios = empleadoDTO.horario().stream().map(this::convertirCrearHorarioADominio).collect(Collectors.toList());
        empleado.setHorario(horarios);

        // Guardar el empleado en la base de datos
        empleadoRepo.save(empleado);
    }

    private Horario convertirCrearHorarioADominio(CrearHorarioDTO horarioDTO) {
        Horario horario = new Horario();
        horario.setDia(horarioDTO.dia());
        horario.setHoraEntrada(horarioDTO.horaEntrada());
        horario.setHoraSalida(horarioDTO.horaSalida());
        horario.setHorasTrabajadas(horarioDTO.horasATrabajar());
        return horario;
    }

    @Override
    public void actualizarEmpleado(String id, ActualizarEmpleadoDTO empleadoDTO) throws EmpleadoException {
        // Buscar el empleado por ID
        Empleado empleadoExistente = empleadoRepo.findById(id)
                .orElseThrow(() -> new EmpleadoException("El empleado con el ID " + id + " no existe."));

        // Validar si el teléfono es único
        if (empleadoRepo.existsByTelefono(empleadoDTO.telefono()) &&
                !empleadoExistente.getTelefono().equals(empleadoDTO.telefono())) {
            throw new EmpleadoException("Ya existe un empleado con el mismo número de teléfono.");
        }

        // Actualizar los campos del empleado existente con los nuevos datos
        empleadoExistente.setNombre(empleadoDTO.nombre());
        empleadoExistente.setTelefono(empleadoDTO.telefono());
        empleadoExistente.setEspecialidad(empleadoDTO.especialidad());

        // Actualizar los horarios del empleado manteniendo los mismos IDs
        List<Horario> horariosActualizados = empleadoDTO.horario().stream()
                .map(dto -> {
                    // Encontrar el horario existente por ID o lanzar excepción si no lo encuentra
                    Horario horarioExistente = null;
                    try {
                        horarioExistente = empleadoExistente.getHorario().stream()
                                .filter(h -> h.getId().equals(dto.id()))
                                .findFirst()
                                .orElseThrow(() -> new EmpleadoException("El horario con ID " + dto.id() + " no existe."));
                    } catch (EmpleadoException e) {
                        throw new RuntimeException(e);
                    }

                    // Actualizar los valores del horario existente
                    horarioExistente.setDia(dto.dia());
                    horarioExistente.setHoraEntrada(dto.horaEntrada());
                    horarioExistente.setHoraSalida(dto.horaSalida());
                    horarioExistente.setHorasTrabajadas(dto.horasTrabajadas());

                    return horarioExistente;  // Devolver el horario actualizado
                })
                .collect(Collectors.toList());

        empleadoExistente.setHorario(horariosActualizados);

        // Guardar los cambios en la base de datos
        empleadoRepo.save(empleadoExistente);
    }

    @Override
    public void eliminarEmpleado(String id) throws EmpleadoException {
        // Verificar si el empleado existe
        if (!empleadoRepo.existsById(id)) {
            throw new EmpleadoException("El empleado con el ID " + id + " no existe.");
        }

        // Eliminar el empleado de la base de datos
        empleadoRepo.deleteById(id);
    }

    @Override
    public List<ObtenerEmpleadoDTO> obtenerTodosLosEmpleados() throws EmpleadoException {
        List<Empleado> empleados = empleadoRepo.findAll();

        if (empleados.isEmpty()) {
            throw new EmpleadoException("No se encontraron empleados.");
        }

        // Convertir la lista de empleados a DTO
        return empleados.stream()
                .map(this::convertirEmpleadoAObtenerEmpleadoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ObtenerEmpleadoDTO obtenerEmpleadoPorId(String id) throws EmpleadoException {
        Empleado empleado = empleadoRepo.findById(id)
                .orElseThrow(() -> new EmpleadoException("Empleado con ID " + id + " no encontrado."));

        // Convertir el empleado a DTO
        return convertirEmpleadoAObtenerEmpleadoDTO(empleado);
    }

    private ObtenerEmpleadoDTO convertirEmpleadoAObtenerEmpleadoDTO(Empleado empleado) {
        return new ObtenerEmpleadoDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getTelefono(),
                empleado.getHorario().stream()
                        .map(this::convertirHorarioAObtenerHorarioDTO)
                        .collect(Collectors.toList()),
                empleado.getEspecialidad()
        );
    }

    private HorarioDTO convertirHorarioAObtenerHorarioDTO(Horario horario) {
        return new HorarioDTO(
                horario.getId(),
                horario.getDia(),
                horario.getHoraEntrada(),
                horario.getHoraSalida(),
                horario.getHorasTrabajadas()
        );
    }

}