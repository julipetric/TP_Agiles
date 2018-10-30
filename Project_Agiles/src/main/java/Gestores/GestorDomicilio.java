/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Exceptions.DatosDomicilioException;
import Exceptions.DatosTitularException;

/**
 *
 * @author tomas
 */
public class GestorDomicilio {

    static boolean validarDomicilio(String ciudad, String calle, String numero, String piso, String departamento) throws  DatosDomicilioException{
        DatosDomicilioException exception = new DatosDomicilioException();
        boolean ok=true;
        if(ciudad.length()==0)
        {
            ok=false;
            exception.setCiudad(false);
        }
        if(calle.length()==0)
        {
            ok=false;
            exception.setCalle(false);
        }
        if(numero.length()==0)
        {
            ok=false;
            exception.setNumero(false);
        }
        if(!ok) throw exception;
        return ok;
    }
    
}
