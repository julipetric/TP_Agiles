/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JUnit;

import Daos.DomicilioDao;
import Daos.LicenciaDao;
import Daos.TitularDao;
import Daos.UsuarioDao;
import Gestores.GestorLicencias;
import Modelo.Licencia;
import java.util.ArrayList;
import java.util.Random;
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

/**Este test encuentra falsos positivos, pero no falsos negativos.
 *Es decir que sirve para controlar que lo que se traiga de la BD
 * cumpla los criterios de la busqueda, pero no asegura que se esten
 * trayendo de la BD todas las licencias que cumplen los criterios.
 * @author lsant
 */
public class TestBusquedaPorCriterios {
    
    ArrayList<Object> criterios;
    ArrayList<Licencia> licencias;
    String grupos[] = {"-","0","A","B","AB"};
    String factores[] = {"-","Positivo","Negativo"};
    String clases[] = {"-","A","B","C","E","G"};
    Random r;
    
    
    public TestBusquedaPorCriterios() {
        Configuration configuracion = new Configuration();
        configuracion.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuracion.getProperties());
        SessionFactory fabricaSesion = configuracion.buildSessionFactory(ssrb.build());
        Session sesion = fabricaSesion.openSession();

        DomicilioDao.setSession(sesion);
        LicenciaDao.setSesion(sesion);
        TitularDao.setSesion(sesion);
        UsuarioDao.setSesion(sesion);
        
        criterios = new ArrayList<>(10);
        for(int i=0;i<10;i++) criterios.add(i,null);
        
        r=new Random();
    }
    
    private void chequear(String nombre, String apellido, String dni, String nroLicencia, 
            String grupo, String factor, String clase, Boolean donante, Boolean vigenteSi, Boolean vigenteNo){
        criterios.set(0,nombre);
        criterios.set(1,apellido);
        criterios.set(2,dni);
        criterios.set(3,nroLicencia);
        criterios.set(4,grupo);
        criterios.set(5,factor);
        criterios.set(6,clase);
        criterios.set(7,donante);
        criterios.set(8,vigenteSi);
        criterios.set(9,vigenteNo);
        
        licencias = GestorLicencias.buscarPorCriterios(criterios);
        
        for(Licencia licencia : licencias){
            if(!nombre.isEmpty()) assertTrue(nombre.equals(licencia.getTitular().getNombre()));
            if(!apellido.isEmpty()) assertTrue(apellido.equals(licencia.getTitular().getApellido()));
            if(!dni.isEmpty()) assertTrue(Integer.valueOf(dni).equals(licencia.getTitular().getDni()));
            if(!nroLicencia.isEmpty()) assertTrue(Integer.valueOf(nroLicencia).equals(licencia.getUid()));
            if(!grupo.equals("-")) assertTrue(grupo.equals(licencia.getTitular().getGrupoSanguineo()));
            if(!factor.equals("-")) assertTrue(factor.equals(licencia.getTitular().getFactorRh()));
            if(!clase.equals("-")) assertTrue(clase.equals(licencia.getClase()));
            if(donante!=null) assertTrue(donante==licencia.getTitular().isEsDonante());
            if(vigenteSi^vigenteNo) assertTrue(GestorLicencias.esVigente(licencia)==vigenteSi);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1(){
        chequear("","","","",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],null,true,true);
    }
    
    @Test
    public void test2(){
        chequear("","","39717462","",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],null,true,false);
    }
    
    @Test
    public void test3(){
        chequear("Luis Santiago","Re","","",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],null,false,true);
    }
    
    @Test
    public void test4(){
        chequear("","Re","","",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],null,false,false);
    }
    
    @Test
    public void test5(){
        chequear("","","","1",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],true,true,true);
    }
    
    @Test
    public void test6(){
        chequear("","","","2",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],true,true,false);
    }
    
    @Test
    public void test7(){
        chequear("","","","4",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],true,false,true);
    }
    
    @Test
    public void test8(){
        chequear("","","","8",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],true,false,false);
    }
    
    @Test
    public void test9(){
        chequear("","","","16",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],false,true,true);
    }
    
    @Test
    public void test10(){
        chequear("","","","",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],false,true,false);
    }
    
    @Test
    public void test11(){
        chequear("","","","",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],false,false,true);
    }
    
    @Test
    public void test12(){
        chequear("","Re","39717462","",grupos[r.nextInt(5)],factores[r.nextInt(3)],clases[r.nextInt(6)],false,false,false);
    }
}
