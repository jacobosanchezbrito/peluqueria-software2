package co.edu.uniquindio.peluqueria.exceptions;

public class ServicioException extends Exception{

    //Metodo que permite enviar mensaje de error mediante una excepcion
    public ServicioException(String message) {
        super(message);
    }
}
