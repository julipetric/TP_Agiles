/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author matij
 */
public class UsuarioDao {

    private static Session sesion;

    public static Session getSesion() {
        return sesion;
    }

    public static void setSesion(Session sesion) {
        UsuarioDao.sesion = sesion;
    }

    public static Usuario find(Integer dni) {
        Transaction tx = null;
        List usuarios = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            usuarios = sesion.createQuery("FROM Usuario u WHERE u.dni ='" + dni).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        if (usuarios.size() == 1) {
            return (Usuario) usuarios.get(0);
        } else {
            return null;
        }
    }
    
    public static Usuario find(String nombreUsuario, String contra) {
        Transaction tx = null;
        List usuarios = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            usuarios = sesion.createQuery("FROM Usuario u WHERE u.usuarioNombre ='" + nombreUsuario+"' AND u.usuarioContrasena ='"+contra+"'").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        if (usuarios.size() == 1) {
            return (Usuario) usuarios.get(0);
        } else {
            return null;
        }
    }
    
    

    public static ArrayList<Usuario> getAllUsuarios() {
        Transaction tx = null;
        List usuarios = new ArrayList<>();
        try {
            tx = sesion.beginTransaction();
            usuarios = sesion.createQuery("FROM Usuario").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        ArrayList<Usuario> user = new ArrayList<>();
        for (Object o : usuarios) {
            user.add((Usuario) o);
        }
        return user;
    }

    public static void modify(Usuario mU) {
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(mU);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void insert(Usuario nU) {
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(nU);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
