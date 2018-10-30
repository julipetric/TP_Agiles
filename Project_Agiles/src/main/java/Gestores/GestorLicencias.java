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

        ArrayList<Object> criteriosArray = new ArrayList();

        criteriosArray.add(criterios.get(0)); //nombre
        criteriosArray.add(criterios.get(1)); //apellido
        
        //dni
        if (!criterios.get(2).equals("")) {
            criteriosArray.add(Integer.parseInt((String) criterios.get(2)));
        } else {
            criteriosArray.add(null);
        }
        
        //nroLic
        if (!criterios.get(3).equals("")) {
            criteriosArray.add(Integer.parseInt((String) criterios.get(3)));
        } else {
            criteriosArray.add(null);
        }
        
        criteriosArray.add(criterios.get(4)); //grupo
        criteriosArray.add(criterios.get(5)); //factor
        criteriosArray.add(criterios.get(6)); //clase
        criteriosArray.add((Boolean) criterios.get(7)); //donanteSi
        criteriosArray.add((Boolean) criterios.get(8)); //vencidas
        criteriosArray.add((Boolean) criterios.get(9)); //noVencidas

        ArrayList<Licencia> lista = new ArrayList<>();
        lista = LicenciaDao.buscarPorCriterios(
                (String) criteriosArray.get(0),
                (String) criteriosArray.get(1),
                (Integer) criteriosArray.get(2),
                (Integer) criteriosArray.get(3),
                (String) criteriosArray.get(4),
                (String) criteriosArray.get(5),
                (String) criteriosArray.get(6),
                (Boolean) criteriosArray.get(7),
                (Boolean) criteriosArray.get(8),
                (Boolean) criteriosArray.get(9)
        );
        return lista;

    }
}
