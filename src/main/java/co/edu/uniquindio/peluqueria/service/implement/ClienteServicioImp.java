package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Cliente.CrearClienteDTO;
import co.edu.uniquindio.peluqueria.exceptions.ClienteException;
import co.edu.uniquindio.peluqueria.model.documents.Cliente;
import co.edu.uniquindio.peluqueria.repository.ClienteRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImp implements ClienteServicio {

    @Autowired
    private ClienteRepo clienteRepo;

    @Override
    public void crearCliente(CrearClienteDTO clienteDTO) throws ClienteException {
        // Validación para verificar si ya existe un cliente con el mismo teléfono
        if (clienteRepo.existsByTelefono(clienteDTO.getTelefono())) {
            throw new ClienteException("Ya existe un cliente con el teléfono: " + clienteDTO.getTelefono());
        }

        // Validación para verificar si ya existe un cliente con el mismo correo
        if (clienteRepo.existsByCorreo(clienteDTO.getCorreo())) {
            throw new ClienteException("Ya existe un cliente con el correo: " + clienteDTO.getCorreo());
        }

        // Crear instancia de Cliente usando el DTO
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setCorreo(clienteDTO.getCorreo()); // Agregar correo
        cliente.setContrasena(clienteDTO.getContrasena()); // Agregar contraseña

        // Guardar el cliente en la base de datos
        clienteRepo.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(String id) throws ClienteException {
        Optional<Cliente> clienteOptional = clienteRepo.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new ClienteException("No se encontró el cliente con ID: " + id);
        }
        return clienteOptional.get();
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void actualizarCliente(String id, CrearClienteDTO clienteDTO) throws ClienteException {
        // Buscar el cliente por ID
        Optional<Cliente> clienteOptional = clienteRepo.findById(id);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            // Actualizar los campos con los nuevos datos del DTO
            cliente.setNombre(clienteDTO.getNombre());
            cliente.setTelefono(clienteDTO.getTelefono());
            cliente.setCorreo(clienteDTO.getCorreo()); // Agregar actualización de correo
            cliente.setContrasena(clienteDTO.getContrasena()); // Agregar actualización de contraseña

            // Guardar los cambios
            clienteRepo.save(cliente);

        } else {
            throw new ClienteException("No se encontró el cliente con el ID: " + id);
        }
    }

    @Override
    public void eliminarCliente(String id) throws ClienteException {
        if (!clienteRepo.existsById(id)) {
            throw new ClienteException("No se encontró el cliente con ID: " + id);
        }
        clienteRepo.deleteById(id);
    }
}
