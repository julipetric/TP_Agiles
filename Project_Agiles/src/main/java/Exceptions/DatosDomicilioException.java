/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author tomas
 */
public class DatosDomicilioException extends Exception{
    
    private boolean ciudad, calle, numero, piso, departamento; 
    
    public DatosDomicilioException() {
        super("Datos de domicilio incorrectos");
        ciudad=true;
        calle=true;
        numero=true;
        piso=true;
        departamento=true;
    }

    public boolean getCiudad() {
        return ciudad;
    }

    public void setCiudad(boolean ciudad) {
        this.ciudad = ciudad;
    }

    public boolean getCalle() {
        return calle;
    }

    public void setCalle(boolean calle) {
        this.calle = calle;
    }

    public boolean getNumero() {
        return numero;
    }

    public void setNumero(boolean numero) {
        this.numero = numero;
    }

    public boolean getPiso() {
        return piso;
    }

    public void setPiso(boolean piso) {
        this.piso = piso;
    }

    public boolean getDepartamento() {
        return departamento;
    }

    public void setDepartamento(boolean departamento) {
        this.departamento = departamento;
    }
    
    
}
