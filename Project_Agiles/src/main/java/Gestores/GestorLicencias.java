/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.LicenciaDao;
import Modelo.Licencia;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    
    
    public static void calcularVigencia(Licencia licencia) {
        /*Durante la emisión de la licencia, se establece la vigencia de la misma,
        de acuerdo a la siguiente tabla:
        
        Menores de 21 años: 1 año la primera vez y 3 años las siguientes
        Hasta 46 años: 5 años
        Hasta 60 años: 4 años
        Hasta 70 años: 3 años
        Mayores de 70 años: 1 año
        
        El día y mes de la fecha de vencimiento deben coincidir con el día y mes
        de la fecha de nacimiento del titular, respectivamente. La fecha de inicio
        de vigencia debe ser la fecha del sistema, y no puede cambiarse.*/
        
        Date nacimiento = licencia.getTitular().getFechaNacimiento();
        
        LocalDate inicioPeriodo = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate finPeriodo = LocalDate.now();
 
        int diferencia = Period.between(inicioPeriodo, finPeriodo).getYears(); //Años del titular
        int vigencia = 0; //Vigencia de la licencia (en años)
        
        if (diferencia < 21) {
            if (licencia.getTitular().getLicencias().isEmpty()) { //Si es su primera licencia
                vigencia = 1;
            } else {
                vigencia = 3;
            }
        } else if (diferencia >= 21 && diferencia <= 46) {
            vigencia = 5;
        }  else if (diferencia > 46 && diferencia <= 60) {
            vigencia = 4;
        }  else if (diferencia > 60 && diferencia <= 70) {
            vigencia = 3;
        } else if (diferencia > 70) {
            vigencia = 1;
        }
        
        Calendar cal = Calendar.getInstance(); //Fecha de hoy
        int anyoActual = cal.get(Calendar.YEAR); //Obtener año actual
        
        cal.setTime(nacimiento); //Fecha de nacimieto
        cal.set(Calendar.YEAR, anyoActual+vigencia);
        Date vencimiento = cal.getTime(); //Dia y mes de nacimieto pero con año actual+años de vigencia
        
        licencia.setFechaExpiracion(vencimiento);
        licencia.setFechaTramite(new Date()); //Fecha tramite = fecha actual

    }
}
