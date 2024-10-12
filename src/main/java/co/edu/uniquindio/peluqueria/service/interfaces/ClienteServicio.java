package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Cliente.CrearClienteDTO;
import co.edu.uniquindio.peluqueria.exceptions.ClienteException;
import co.edu.uniquindio.peluqueria.model.documents.Cliente;

import java.util.List;

public interface ClienteServicio {

    void crearCliente(CrearClienteDTO clienteDTO) throws ClienteException;
    Cliente obtenerClientePorId(String id) throws ClienteException;
    List<Cliente> obtenerTodosLosClientes();
    void actualizarCliente(String id, CrearClienteDTO clienteDTO) throws ClienteException;
    void eliminarCliente(String id) throws ClienteException;

}
