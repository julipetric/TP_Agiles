/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoalfa.tp_testing;

import Daos.DomicilioDao;
import Daos.LicenciaDao;
import Daos.TitularDao;
import Daos.UsuarioDao;
import Gestores.GestorLicencias;
import Modelo.Licencia;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Julian
 */
public class licenciasTest {

    //Constante que representa la cantidad de licencias total en la tabla
    //como entero
    final Integer cantidadLicencias = 0;

    private ArrayList<Object> criteriosVacio = new ArrayList<>();

    public licenciasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Configuration configuracion = new Configuration();
        configuracion.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuracion.getProperties());
        SessionFactory fabricaSesion = configuracion.buildSessionFactory(ssrb.build());
        Session sesion = fabricaSesion.openSession();
        
        DomicilioDao.setSession(sesion);
        LicenciaDao.setSesion(sesion);
        TitularDao.setSesion(sesion);
        UsuarioDao.setSesion(sesion);
        
        criteriosVacio.add(""); //nombre
        criteriosVacio.add(""); //apellido
        criteriosVacio.add(""); //dni
        criteriosVacio.add(""); //nro licencia
        criteriosVacio.add("-"); //grupo
        criteriosVacio.add("-"); //factor
        criteriosVacio.add("-"); //clase
        criteriosVacio.add(true); //donanteSi
        criteriosVacio.add(true); //vencidas
        criteriosVacio.add(true); //noVencidas
        
    }

    @After
    public void tearDown() {
    }
/*
    @Test
    
public void buscarTodasLasLicencias() {
        ArrayList<Licencia> lista = GestorLicencias.buscarPorCriterios(criteriosVacio);
        Integer tamano = lista.size();
        assertEquals(tamano, cantidadLicencias);
    }
*/
}
