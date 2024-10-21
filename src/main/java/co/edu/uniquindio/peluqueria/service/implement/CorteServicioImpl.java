package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Corte.CrearCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.EditarCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.InformacionCorteDTO;
import co.edu.uniquindio.peluqueria.model.documents.Corte;
import co.edu.uniquindio.peluqueria.repository.CorteRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.CorteServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorteServicioImpl implements CorteServicio {

    private final CorteRepo corteRepo;

    public CorteServicioImpl(CorteRepo corteRepo) {
        this.corteRepo = corteRepo;
    }

    @Override
    public String crearCorte(CrearCorteDTO corteDTO) throws Exception {
        Corte corte = new Corte(
                null,
                corteDTO.titulo(),
                corteDTO.imagen(),
                corteDTO.descripcion(),
                corteDTO.tipoCorte(),
                corteDTO.tiempo(),
                corteDTO.precio(),
                null
        );
        Corte corteGuardado = corteRepo.save(corte);
        return corteGuardado.getIdCorte();
    }

    @Override
    public String editarCuenta(EditarCorteDTO corteDTO) throws Exception {
        Optional<Corte> corteOptional = corteRepo.findById(corteDTO.titulo()); // Cambia según cómo identifiques el corte

        if (corteOptional.isPresent()) {
            Corte corte = corteOptional.get();
            corte.setImagen(corteDTO.imagen());
            corte.setDescripcion(corteDTO.descripcion());
            corte.setTipoCorte(corteDTO.tipoCorte());
            corte.setTiempo(corteDTO.tiempo());
            corte.setPrecio(corteDTO.precio());

            corteRepo.save(corte);
            return "Corte editado correctamente.";
        } else {
            throw new Exception("Corte no encontrado.");
        }
    }

    @Override
    public String eliminarCuenta(String id) throws Exception {
        if (corteRepo.existsById(id)) {
            corteRepo.deleteById(id);
            return "Corte eliminado correctamente.";
        } else {
            throw new Exception("Corte no encontrado.");
        }
    }

    @Override
    public InformacionCorteDTO obtenerInformacionCorte(String id) throws Exception {
        Corte corte = corteRepo.findById(id).orElseThrow(() -> new Exception("Corte no encontrado."));
        return new InformacionCorteDTO(
                corte.getTitulo(),
                corte.getImagen(),
                corte.getDescripcion(),
                corte.getTipoCorte(),
                corte.getTiempo(),
                corte.getPrecio()
        );
    }

    @Override
    public List<Corte> listarCortes() {
        return corteRepo.findAll();
    }
}

