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

        String nombre = (String) criterios.get(0);
        String apellido = (String) criterios.get(1);
        Integer dni = Integer.parseInt((String) criterios.get(2));
        Integer nroLic = Integer.parseInt((String) criterios.get(3));
        String grupo = (String) criterios.get(4);
        String factor = (String) criterios.get(5);
        String clase = (String) criterios.get(6);
        Boolean donante = Boolean.parseBoolean((String) criterios.get(7));
        Boolean vencidas = Boolean.parseBoolean((String) criterios.get(8));
        Boolean noVencidas = Boolean.parseBoolean((String) criterios.get(9));
        

        ArrayList<Licencia> lista = new ArrayList<>();
        lista = LicenciaDao.buscarPorCriterios(nombre, apellido, dni, nroLic, grupo, factor, clase, donante, vencidas, noVencidas);
        return lista;

    }
}
