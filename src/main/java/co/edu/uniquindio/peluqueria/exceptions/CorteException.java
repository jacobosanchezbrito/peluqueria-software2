package co.edu.uniquindio.peluqueria.exceptions;

public class CorteException extends Exception{

    //Metodo que permite enviar mensaje de error mediante una excepcion
    public CorteException(String message) {
        super(message);
    }
}
