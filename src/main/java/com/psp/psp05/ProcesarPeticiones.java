package com.psp.psp05;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * ProcesarPeticiones
 */
public class ProcesarPeticiones extends Thread {

    private final Socket socketCliente;

    public ProcesarPeticiones(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    
    @Override
    public void run() {
        try {
            //Procesar peticion HTTP
            ServidorHTTP.procesaPeticion(this.socketCliente);
            //cierra la conexión entrante
            this.socketCliente.close();
            System.out.println("cliente atendido");
        } catch (IOException ex) {
            System.err.println("Error: ".concat(ex.getMessage()));
        }
    }

}
