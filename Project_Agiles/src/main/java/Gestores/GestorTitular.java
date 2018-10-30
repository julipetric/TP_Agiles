/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.TitularDao;
import Exceptions.DatosDomicilioException;
import Exceptions.DatosTitularException;
import Modelo.Domicilio;
import Modelo.Titular;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tomas
 */
public class GestorTitular {

    public static boolean guardarTitular(String nombre, String apellido, String dni, Date fechaNacimiento, String grupoSanguineo,
            String factorRh, Boolean esDonante, String ciudad, String calle, String numero, String piso, String departamento)
            throws DatosTitularException {
        boolean ok=true;
        DatosTitularException exception = new DatosTitularException();
        
        try{
            validarDatosTitular(nombre, apellido, dni);
        }
        catch(DatosTitularException e)
        {
            ok=false;
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
        else{
            Domicilio domicilio = new Domicilio(ciudad, calle, Integer.valueOf(numero), Integer.valueOf(piso), departamento);
            Titular titular = new Titular(Integer.valueOf(dni),domicilio,nombre,apellido,fechaNacimiento,grupoSanguineo,factorRh,esDonante);
            TitularDao.insert(titular);
        }
        return ok;
    }

    private static boolean validarDatosTitular(String nombre, String apellido, String dni) throws DatosTitularException {
        boolean ok=true;
        DatosTitularException exception = new DatosTitularException();
        if(dni.length()<6)
        {
            ok=false;
            exception.setDni(false);
        }
        if(nombre.length()==0)
        {
            ok=false;
            exception.setNombre(false);
        }
        if(apellido.length()==0)
        {
            ok=false;
            exception.setApellido(false);
        }
        if(!ok) throw exception;
        return ok;
    }
}
