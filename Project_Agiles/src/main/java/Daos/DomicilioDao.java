/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Domicilio;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author matij
 */
public class DomicilioDao {

    private static Session sesion;

    public static Session getSesion() {
        return sesion;
    }

    public static void setSesion(Session sesion) {
        DomicilioDao.sesion = sesion;
    }

    public static Domicilio find(Integer uid) {
        Transaction tx = null;
        List domicilios = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            domicilios = sesion.createQuery("FROM Domicilio d WHERE d.uid ='" + uid).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        if (domicilios.size() == 1) {
            return (Domicilio) domicilios.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Domicilio> getAllDomicilios() {
        Transaction tx = null;
        List domicilios = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            domicilios = sesion.createQuery("FROM Usuario").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        ArrayList<Domicilio> dom = new ArrayList<>();
        for (Object o : domicilios) {
            dom.add((Domicilio) o);
        }
        return dom;
    }

    public static void modify(Domicilio mD) {
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(mD);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void insert(Domicilio nD) {
        Transaction tx = null;
        
        try {
            tx = sesion.beginTransaction();
            Integer dID = (Integer) sesion.save(nD);
            nD.setUid(dID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void setSession(Session sesion) {
          
        DomicilioDao.sesion = sesion;
    
    }
}
