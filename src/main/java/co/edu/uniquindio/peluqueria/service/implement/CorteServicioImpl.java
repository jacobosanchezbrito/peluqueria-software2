package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Corte.CrearCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.EditarCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.InformacionCorteDTO;
import co.edu.uniquindio.peluqueria.exceptions.CorteException;
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
    public String crearCorte(CrearCorteDTO corteDTO) throws CorteException {
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
    public String editarCuenta(String id, EditarCorteDTO corteDTO) throws CorteException {
        Optional<Corte> corteOptional = corteRepo.findById(id);

        if (corteOptional.isPresent()) {
            Corte corte = corteOptional.get();
            corte.setTitulo(corteDTO.titulo());
            corte.setImagen(corteDTO.imagen());
            corte.setDescripcion(corteDTO.descripcion());
            corte.setTipoCorte(corteDTO.tipoCorte());
            corte.setTiempo(corteDTO.tiempo());
            corte.setPrecio(corteDTO.precio());

            corteRepo.save(corte);
            return "Corte editado correctamente.";
        } else {
            throw new CorteException("Corte no encontrado.");
        }
    }

    @Override
    public String eliminarCuenta(String id) throws CorteException {
        if (corteRepo.existsById(id)) {
            corteRepo.deleteById(id);
            return "Corte eliminado correctamente.";
        } else {
            throw new CorteException("Corte no encontrado.");
        }
    }

    @Override
    public InformacionCorteDTO obtenerInformacionCorte(String id) throws CorteException {
        Corte corte = corteRepo.findById(id).orElseThrow(() -> new CorteException("Corte no encontrado."));
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

