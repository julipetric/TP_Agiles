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
public class DatosTitularException extends Exception  {
    private boolean nombre, apellido, dni;
    DatosDomicilioException domicilioException;
    
      public DatosTitularException() {
        super("Datos de titular incorrectos");
        domicilioException = new DatosDomicilioException();
        nombre=true;
        apellido=true;
        dni=true;
    }
      
    public void setDomicilioException(DatosDomicilioException domicilioException){
        this.domicilioException = domicilioException;
    }
    
    public DatosDomicilioException getDomicilioException(){
        return domicilioException;
    }

    public boolean getNombre() {
        return nombre;
    }

    public void setNombre(boolean nombre) {
        this.nombre = nombre;
    }

    public boolean getApellido() {
        return apellido;
    }

    public void setApellido(boolean apellido) {
        this.apellido = apellido;
    }

    public boolean getDni() {
        return dni;
    }

    public void setDni(boolean dni) {
        this.dni = dni;
    }
      
      
    
}
