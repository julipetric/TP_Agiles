/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.LicenciaDao;
import Exceptions.DatosLicenciaException;
import Modelo.Licencia;
import Modelo.Titular;
import Modelo.Usuario;
import java.time.Instant;
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
    
    /**
     * Este método se encarga de realizar la busqueda de licencias mediante diferentes criterios.
     *
     * @author Luciano Marthinez Almudevar 
     * @return retorna las licencias expiradas
     */
    public static ArrayList<Licencia> getLicenciasExpiradas() {
        return LicenciaDao.getExpiradas();
    }
    
   /**
     * Este método se encarga de realizar la busqueda de licencias mediante diferentes criterios.
     *
     * @author Luciano Marthinez Almudevar 
     * @param criterios  arreglo que contiene los criterios de busqueda.
     * @return retorna las licencias que cumplan con los criterios
     */
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

    /**
     * Este método se encarga de calcular la fecha de expiracion de la licencia.
     * 
     * Durante la emisión de la licencia, se establece la vigencia de la misma,
     * de acuerdo a la siguiente tabla: Menores de 21 años: 1 año la primera vez
     * y 3 años las siguientes Hasta 46 años: 5 años Hasta 60 años: 4 años Hasta
     * 70 años: 3 años Mayores de 70 años: 1 año El día y mes de la fecha de
     * vencimiento deben coincidir con el día y mes de la fecha de nacimiento
     * del titular, respectivamente. La fecha de inicio de vigencia debe ser la
     * fecha del sistema, y no puede cambiarse.
     *
     * @author Luciano Marthinez Almudevar 
     * @param licencia instancia de una licencia a la que se le desea calcular la fecha de expiracion.s

     */
    private static void calcularVigencia(Licencia licencia) {

        Date nacimiento = licencia.getTitular().getFechaNacimiento();
        
        LocalDate inicioPeriodo = Instant.ofEpochMilli(nacimiento.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        //LocalDate inicioPeriodo = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
        } else if (diferencia > 46 && diferencia <= 60) {
            vigencia = 4;
        } else if (diferencia > 60 && diferencia <= 70) {
            vigencia = 3;
        } else if (diferencia > 70) {
            vigencia = 1;
        }

        Calendar cal = Calendar.getInstance(); //Fecha de hoy
        int anyoActual = cal.get(Calendar.YEAR); //Obtener año actual

        cal.setTime(nacimiento); //Fecha de nacimieto
        cal.set(Calendar.YEAR, anyoActual + vigencia);
        Date vencimiento = cal.getTime(); //Dia y mes de nacimieto pero con año actual+años de vigencia

        licencia.setFechaExpiracion(vencimiento);
        licencia.setFechaTramite(new Date()); //Fecha tramite = fecha actual
        calcularCosto(vigencia, licencia);
    }

    /**
     * Este método se encarga de realizar el calculo del costo de la licencia.
     *
     * @author Tomás Fleitas - Jean Pierre Saint Martin
     * @param vigencia es la cantidad de años que dura la licencia
     * @param licencia es la licencia a la cual se le calculara el costo
     */
    private static void calcularCosto(Integer vigencia, Licencia licencia) {
        String clase = licencia.getClase();
        ArrayList<String> clases = new ArrayList<String>();
        clases.add("A");
        clases.add("B");
        clases.add("C");
        clases.add("E");
        clases.add("G");
        ArrayList<Integer> vigencias = new ArrayList<Integer>();
        vigencias.add(5);
        vigencias.add(4);
        vigencias.add(3);
        vigencias.add(1);
        Integer costo[][] = {{40, 30, 25, 20},
        {48, 38, 25 + 8, 28},
        {47 + 8, 35 + 8, 38, 23 + 8},
        {59 + 8, 44 + 8, 39 + 8, 29 + 8},
        {48, 38, 25 + 8, 28}};
        int a = clases.indexOf(clase);
        int b = vigencias.indexOf(vigencia);
        licencia.setCosto(costo[a][b]);
    }

    /**
     * Este método se encarga de crear una licencia y ademas le completa los datos de fecha de expiracion y el costo de la misma.
     * 
     * @author Tomás Fleitas - Jean Pierre Saint Martin
     * @param titular  es la instancia del titular de la licencia.
     * @param usuario  es el operario actual de la sesion.
     * @param clase  es el tipo de licencia.
     * @return Instancia de una Licencia con todos los atributos seteados.
     */
    public static Licencia crearLicencia(Titular titular, Usuario usuario, String clase) throws DatosLicenciaException {
        Licencia licencia = null;
        if (titular != null && usuario != null && !clase.isEmpty()) {
            licencia = new Licencia(titular, usuario, clase);
            calcularVigencia(licencia);
        } else {
            throw new DatosLicenciaException();
        }

        return licencia;
    }

    /**
     * Este método se encarga de comunicarse con el LicenciaDao para que el mismo lo persiste.
     * 
     * @author Tomás Fleitas - Jean Pierre Saint Martin
     * @param licencia   es la instancia de la licencia que se desea guardar.
     */
    public static void guardarLicencia(Licencia licencia) {
        LicenciaDao.insert(licencia);
    }

    
    /**
     * Este método se encarga de buscar y retornar una licencia de la base de datos pasandole como parametro su uid.
     * 
     * @author Tomás Fleitas - Jean Pierre Saint Martin
     * @param uid  ID de una licencia.
     */
    public static Licencia getLicencia(Integer uid){
       return LicenciaDao.find(uid);
    }
    
    /**
     * Este método se encarga de modificar la licencia, cambiar el valor del atributo de la licencia vieja y guardar la licencia nueva.
     * 
     * @author Matias Jacob - Tomás Fleitas
     * @param titular 
     * @param usuario 
     * @param clase
     * @param lic
     * @return retorna una licencia nueva
     */
    public static Licencia modificarLicencia(Titular titular, Usuario usuario, String clase, Licencia lic) throws DatosLicenciaException{
        
        lic.setActivo(Boolean.FALSE);
        LicenciaDao.modify(lic);
        Licencia licnueva = crearLicencia(titular,usuario,clase);
        LicenciaDao.insert(licnueva);
        return licnueva;
    }
}
