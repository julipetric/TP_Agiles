/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Julian
 */
public class DatosUsuarioException extends Exception {
    
    private boolean nombre,apellido,dni,usuario,pass,pass2;
    DatosDomicilioException domicilioException;
    
    public DatosUsuarioException() {
        super("Datos de usuario incorrectos");
        domicilioException = new DatosDomicilioException();
        nombre=true;
        apellido=true;
        dni=true;
        usuario=true;
        pass=true;
        pass2=true;
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

    public boolean getUsuario() {
        return usuario;
    }

    public void setUsuario(boolean usuario) {
        this.usuario = usuario;
    }

    public boolean getPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean getPass2() {
        return pass2;
    }

    public void setPass2(boolean pass2) {
        this.pass2 = pass2;
    }


    
}

