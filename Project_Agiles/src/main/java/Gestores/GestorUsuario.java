/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.UsuarioDao;
import Exceptions.DatosUsuarioInvalidosException;

/**
 *
 * @author tomas
 */
public class GestorUsuario {

    public GestorUsuario() {
    }

    public static Boolean darDeAltaUsuario(String dni, String nombre, String apellido, String user, String pass, String pass2) throws DatosUsuarioInvalidosException {
        try{
            validarDatosUsuario(dni, nombre, apellido, user, pass, pass2);
            //TO-DO entrar usuario en BD
        }
        catch(DatosUsuarioInvalidosException e){
            throw e;
        }
        return true;
    }

    private static Boolean validarDatosUsuario(String dni, String nombre, String apellido, String user, String pass, String pass2) throws DatosUsuarioInvalidosException {
        Boolean valido = true;
        DatosUsuarioInvalidosException exception = new DatosUsuarioInvalidosException();
        
        try{
            Integer.parseInt(dni);
        }
        catch(NumberFormatException e){
            valido = false;
            exception.setDni(false);
        }
        if(nombre.isEmpty()){
            valido = false;
            exception.setNombre(false);
        }
        if(apellido.isEmpty()){
            valido = false;
            exception.setApellido(false);
        }
        if(user.isEmpty() || user.length() > 32){
            valido = false;
            exception.setUsuario(false);
        }
        if(pass.isEmpty() || pass.length() < 8){
            valido = false;
            exception.setPass(false);
        }
        if(!pass.equals(pass2)){
            valido = false;
            exception.setPass2(false);
        }
        if(!valido) throw exception;
        return valido;
    }
    
}
