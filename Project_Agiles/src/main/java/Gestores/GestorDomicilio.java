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

    static boolean validarDomicilio(String numero,String departamento ,String calle,String ciudad, String piso ) throws  DatosDomicilioException{
        return numero.length() >= 0 && calle.length() >= 0 && ciudad.length() >= 0;
    }
    
}
