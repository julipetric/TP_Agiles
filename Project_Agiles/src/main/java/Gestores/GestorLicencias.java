/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.Licencia;
import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class GestorLicencias {
 
    public static ArrayList<Licencia> getLicenciasExpiradas() {
        return LicenciaDao.getExpiradas();
    }
}
