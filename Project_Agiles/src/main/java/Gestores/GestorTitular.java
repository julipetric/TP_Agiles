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
            Domicilio domicilio = new Domicilio(ciudad, calle, Integer.valueOf(numero),departamento, Integer.valueOf(piso));
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
    
    
    /**
     * Este método se encarga de modificar los datos de un titular y retornar una instancia del mismo
     * 
     * @author Tomás Fleitas
     * @param nombre  
     * @param apellido  
     * @param dni
     * @param fechaNacimiento 
     * @param grupoSanguineo 
     * @param factorRh 
     * @param esDonante 
     * @param ciudad 
     * @param calle
     * @param numero 
     * @param piso
     * @param departamento 
     *
     * @return retorna un titular nuevo
     */
     public static Titular modificarTitular(String nombre, String apellido, String dni, Date fechaNacimiento, String grupoSanguineo,
            String factorRh, Boolean esDonante, String ciudad, String calle, String numero, String piso, String departamento) throws DatosTitularException {
     
        Titular titular = null;
     
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
            Domicilio domicilio = new Domicilio(ciudad, calle, Integer.valueOf(numero),departamento ,Integer.valueOf(piso));
            titular = new Titular(Integer.valueOf(dni),domicilio,nombre,apellido,fechaNacimiento,grupoSanguineo,factorRh,esDonante);
            TitularDao.modify(titular);
        }
     
     return titular;
     }
}
