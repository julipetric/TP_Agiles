/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.TitularDao;
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

    public static boolean guardarTitular(ArrayList t) throws DatosTitularException {

        try {
            if (validarDatosTitular((String)  t.get(0),(String) t.get(1) ,(int) t.get(2) ,(Date) t.get(9)) && GestorDomicilio.validarDomicilio((String)t.get(3),(String)t.get(4),(String)t.get(5),(String)t.get(6),(String)t.get(7))) {

            } else {
            }
            //Titular titular = new Titular(t.get(0);, domicilio, nombre, apellido, fechaNacimiento, grupoSanguineo, factorRh, true)
        } catch (DatosTitularException e) {
            throw e;
        }

//        TitularDao.insert(t);
        return true;
    }

    private static boolean validarDatosTitular(String nombre, String apellido, int dni, Date fecha) throws  DatosTitularException{
        if (nombre.length() >= 0 && apellido.length() >= 0 && String.valueOf(dni).length() >= 0) {
            //FALTA VALIDAR LA FECHA QUE NO SEA CUALQUIER COSA
            return true;
        }else{
          return false;
        }     
    }
}
