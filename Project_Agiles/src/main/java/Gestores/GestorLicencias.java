/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.LicenciaDao;
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

    public static ArrayList<Licencia> buscarPorCriterios(ArrayList<Object> criterios) {

        ArrayList<String> criteriosString = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            if (criterios.get(i) != null) {
                criteriosString.add(criterios.get(i).toString());
            }
        }

        ArrayList<Licencia> lista = new ArrayList<>();
        lista = LicenciaDao.buscarPorCriterios(criteriosString);
        return lista;

    }
}
