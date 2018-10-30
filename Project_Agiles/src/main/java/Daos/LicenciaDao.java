/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Licencia;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author matij
 */
public class LicenciaDao {

    private static Session sesion;

    public static Session getSesion() {
        return sesion;
    }

    public static void setSesion(Session sesion) {
        LicenciaDao.sesion = sesion;
    }

    public static Licencia find(Integer uid) {
        Transaction tx = null;
        List licencias = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            licencias = sesion.createQuery("FROM Licencia l WHERE l.uid ='" + uid).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        if (licencias.size() == 1) {
            return (Licencia) licencias.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Licencia> getAllLicencia() {
        Transaction tx = null;
        List licencias = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            licencias = sesion.createQuery("FROM Licencia").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        ArrayList<Licencia> lic = new ArrayList<>();
        for (Object o : licencias) {
            lic.add((Licencia) o);
        }
        return lic;
    }

    public static void modify(Licencia mL) {
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(mL);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void insert(Licencia nL) {
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(nL);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static ArrayList<Licencia> buscarPorCriterios(String nombre, String apellido, Integer dni, Integer nroLic, String grupo, String factor, String clase, Boolean donante, Boolean vencidas, Boolean noVencidas) {
        Transaction tx = null;
        List<Object> licencias = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            String query = new String();
            
            if (dni != null) {
                query += "l.titular.dni = " + dni.toString() + " AND ";
            }
            if (!nombre.isEmpty()) {
                query += "l.titular.nombre = '" + nombre + "' AND ";
            }
            if (!apellido.isEmpty()) {
                query += "l.titular.apellido = '" + apellido + "' AND ";
            }
            if(nroLic!=null)
            {
                 query += "l.uid = " + nroLic.toString() + " AND ";
            }
            if (clase != "-") {
                query += "l.clase = '" + clase + "' AND ";
            }
            if (vencidas && !noVencidas) {
                query += "l.fechaExpiracion <= CURDATE()" + " AND ";
            }
            if (!vencidas && noVencidas) {
                query += "l.fechaExpiracion > CURDATE()" + " AND ";
            }
            if (grupo != "-") {
                query += "l.titular.grupoSanguineo = '" + grupo + "' AND ";
            }
            if (factor != "-") {
                query += "l.titular.factorRh = '" + factor + "' AND ";
            }
            if (donante != null) {
                query += "l.titular.esDonante = " + ((donante) ? "1" : "0") + " AND ";
            }
            
            if(!query.isEmpty()){
                query = query.substring(0, query.length()-4);
            }
            query = "FROM Licencia l" + ((query.isEmpty())?"":" WHERE ") + query;

            //query += "l.titular.dni = t.dni";
            
            licencias = sesion.createQuery(query).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        ArrayList<Licencia> result = new ArrayList<>();
        for (Object o : licencias) {
            result.add((Licencia) o);
        }
        
        return result;
        
    }

    public static ArrayList<Licencia> getExpiradas() {
        Transaction tx = null;
        List licenciasexpiradas = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            licenciasexpiradas = sesion.createQuery("FROM Licencia l WHERE l.fechaExpiracion <= CURDATE()").list();
        } catch (HibernateException e) {

        }
        ArrayList<Licencia> lic = new ArrayList<>();
        for (Object o : licenciasexpiradas) {
            lic.add((Licencia) o);
        }
        return lic;
    }

    public static void setSession(Session sesion) {

        LicenciaDao.sesion = sesion;

    }

}
