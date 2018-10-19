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

    public static Boolean darDeAltaUsuario(String dni, String nombre, String apellido, String user, String pass) throws DatosUsuarioInvalidosException {
        try{
            validarDatosUsuario(dni, nombre, apellido, user, pass);
            //TO-DO entrar usuario en BD
        }
        catch(DatosUsuarioInvalidosException e){
            throw e;
        }
        return true;
    }

    private static Boolean validarDatosUsuario(String dni, String nombre, String apellido, String user, String pass) throws DatosUsuarioInvalidosException {
        Boolean valido = true;
        try{
            Integer.parseInt(dni);
        }
        catch(NumberFormatException e){
            throw new DatosUsuarioInvalidosException();
        }
        if(nombre.isEmpty()){
            valido = false;
            throw new DatosUsuarioInvalidosException();
        }
        if(apellido.isEmpty()){
            valido = false;
            throw new DatosUsuarioInvalidosException();
        }
        if(user.isEmpty() || user.length() > 32){
            valido = false;
            throw new DatosUsuarioInvalidosException();
        }
        if(pass.isEmpty() || pass.length() < 8){
            valido = false;
            throw new DatosUsuarioInvalidosException();
        }
        return valido;
    }
    
}
