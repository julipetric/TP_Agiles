/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.UsuarioDao;
import Exceptions.DatosDomicilioException;
import Exceptions.DatosUsuarioException;
import Modelo.Usuario;

/**
 *
 * @author tomas
 */
public class GestorUsuario {

    public GestorUsuario() {
    }

    public static Boolean darDeAltaUsuario(String dni, String nombre, String apellido, String user, String pass, String pass2, String permiso,
            String ciudad, String calle, String numero, String piso, String departamento) throws DatosUsuarioException {
        
        Boolean ok=true;
        DatosUsuarioException exception = new DatosUsuarioException();
        
        try{
            validarDatosUsuario(dni,nombre,apellido,user,pass,pass2);
        }
        catch(DatosUsuarioException e){
            ok = false;
            exception = e;
        }
        
        try{
            GestorDomicilio.validarDomicilio(ciudad, calle, numero, piso, departamento);
        }
        catch(DatosDomicilioException e)
        {
            ok=false;
            exception.setDomicilioException(e);
        }
        
        if(!ok) throw exception;
        /*else{
            Domicilio domicilio = new Domicilio(ciudad, calle, Integer.valueOf(numero), Integer.valueOf(piso), departamento);
            Usuario usuario = new Usuario(Integer.valueOf(dni),domicilio,nombre,apellido,user,pass,permiso);
            UsuarioDao.insert(usuario);
        }*///REVISAR CUESTION DEL DOMICILIO, EL CONSTRUCTOR QUE QUIERO USAR NO EXISTE. La base de datos creo que no le asigna domicilio a un usuario
        
        return ok;
    }

    private static Boolean validarDatosUsuario(String dni, String nombre, String apellido, String user, String pass, String pass2) throws DatosUsuarioException {
        Boolean valido = true;
        DatosUsuarioException exception = new DatosUsuarioException();
        
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
