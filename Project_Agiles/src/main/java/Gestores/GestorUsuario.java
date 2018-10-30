/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.UsuarioDao;
import Exceptions.DatosUsuarioInvalidosException;
import Modelo.Usuario;

/**
 *
 * @author tomas
 */
public class GestorUsuario {

    public GestorUsuario() {
    }

    public static Boolean darDeAltaUsuario(String dni, String nombre, String apellido, String user, String pass, String pass2, String permiso) throws DatosUsuarioInvalidosException {
       boolean a = false;
        try{
            if(validarDatosUsuario(dni, nombre, apellido, user, pass, pass2))
            {
                //TO-DO entrar usuario en BD
                UsuarioDao.insert(new Usuario(Integer.parseInt(dni), nombre, apellido, user, pass, permiso.equals("Administrador")));
                a = true;
            }
        }
        catch(DatosUsuarioInvalidosException e){
            a = false;
            throw e;
        }
        //Ojo, ver tema excepcion en inserción a la BD
        return a;
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
