/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Titular;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author matij
 */
public class TitularDao {

    private static Session sesion;

    public static Session getSesion() {
        return sesion;
    }

    public static void setSesion(Session sesion) {
        TitularDao.sesion = sesion;
    }

    public static Titular find(Integer dni) {
        Transaction tx = null;
        List titulares = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            titulares = sesion.createQuery("FROM Titular t WHERE t.dni ='" + dni+"'").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        if (titulares.size() == 1) {
            return (Titular) titulares.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Titular> getAllTitulares() {
        Transaction tx = null;
        List titulares = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            titulares = sesion.createQuery("FROM Titular").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        ArrayList<Titular> titu = new ArrayList<>();
        for (Object o : titulares) {
            titu.add((Titular) o);
        }
        return titu;
    }


    public static void insert(Titular nT) {
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(nT);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void modify(Titular mT) {
        Transaction tx = null;
        try {
            sesion.clear();
            tx = sesion.beginTransaction();
            sesion.update(mT);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

    }

    public static void setSession(Session sesion) {

        TitularDao.sesion = sesion;

    }
}
