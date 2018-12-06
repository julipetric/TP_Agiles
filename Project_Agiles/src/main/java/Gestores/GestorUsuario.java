/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.UsuarioDao;
import Exceptions.DatosDomicilioException;
import Exceptions.DatosUsuarioException;
import Modelo.Domicilio;
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
        
        
    
        
        boolean permisoAdmin = false;
        
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
        
        boolean dniRepetido = (!dni.isEmpty() && UsuarioDao.find(Integer.valueOf(dni)) != null);
        boolean usuarioRepetido = (!user.isEmpty() && UsuarioDao.find(user) != null);
        
        if (dniRepetido || usuarioRepetido) { //Si hay un usuario con el mismo dni o con el mismo nombre...
            
            //Explota
            ok=false;
            exception.setDni(!dniRepetido);
            exception.setUsuario(!usuarioRepetido);
        }
        
        if (permiso.equalsIgnoreCase("administrador")) {
            permisoAdmin = true;
        }
        
        if(!ok) {
            throw exception;
        } else{
            Domicilio domicilio = new Domicilio(ciudad, calle, Integer.valueOf(numero),departamento, piso.isEmpty()?0:Integer.valueOf(piso));
            GestorDomicilio.guardarDomicilio(domicilio);
            Usuario usuario = new Usuario(Integer.valueOf(dni),nombre,apellido,user,pass,permisoAdmin,domicilio);
            UsuarioDao.insert(usuario);
        }
        
        return ok;
    }

    private static Boolean validarDatosUsuario(String dni, String nombre, String apellido, String user, String pass, String pass2) throws DatosUsuarioException {
        Boolean valido = true;
        DatosUsuarioException exception = new DatosUsuarioException();
        
        try{
            if(dni.length()<7)
            {
                valido = false;
                exception.setDni(false);
            }
            else Integer.parseInt(dni);
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
        if(user.isEmpty()){
            valido = false;
            exception.setUsuario(false);
        }
        if(pass.length() < 8){
            valido = false;
            exception.setPass(false);
        }
        if(!pass.equals(pass2) || pass2.length() < 8){
            valido = false;
            exception.setPass2(false);
        }
        if(!valido) throw exception;
        return valido;
    }
    
}
