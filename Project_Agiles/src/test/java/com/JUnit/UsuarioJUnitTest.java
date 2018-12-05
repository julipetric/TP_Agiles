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
import Exceptions.DatosUsuarioException;
import Gestores.GestorUsuario;
import java.util.Random;
import org.hibernate.cfg.Configuration;
import javafx.util.Pair;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author lsant
 */
public class UsuarioJUnitTest {

    Pair<String, Boolean> dni, nombre, apellido, user, pass, pass2, ciudad, calle, numero, piso, departamento;

    public UsuarioJUnitTest() {
        Configuration configuracion = new Configuration();
        configuracion.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuracion.getProperties());
        SessionFactory fabricaSesion = configuracion.buildSessionFactory(ssrb.build());
        Session sesion = fabricaSesion.openSession();

        DomicilioDao.setSession(sesion);
        LicenciaDao.setSesion(sesion);
        TitularDao.setSesion(sesion);
        UsuarioDao.setSesion(sesion);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /*Antes de cada test ponemos informacion valida en todos los campos.
    /*Los Valores random generados tienen como objetivo que se pueda crear el usuario
    /*siempre que se pruebe el test (hay una probabilidad de falla menor a 
    /* 0.0000001% por motivo de Claves unicas repetidas en la BD, cosa que 
    /* no se esta evaluando).
    */
    @Before
    public void setUp() {
        dni = new Pair(String.valueOf((new Random()).nextInt(100000000-1000000)+1000000), true);
        nombre = new Pair("Luis Santiago", true);
        apellido = new Pair("Re", true);
        user = new Pair("lsantire"+(new Random()).nextInt(), true);
        pass = new Pair("123456789", true);
        pass2 = new Pair("123456789", true);
        ciudad = new Pair("Parana", true);
        calle = new Pair("Cervantes", true);
        numero = new Pair("42", true);
        piso = new Pair("2", true);
        departamento = new Pair("C", true);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void badDniTest1() {
        dni = new Pair("",false);
        chequear();
    }
    
    @Test
    public void badDniTest2(){
        dni = new Pair("999999",false);
        chequear();
    }

    @Test
    public void badNombreTest() {
        nombre = new Pair("",false);
        chequear();
    }

    @Test
    public void badApellidoTest(){
        apellido = new Pair("",false);
        chequear();
    }

    @Test
    public void badUserTest(){
        user = new Pair("",false);
        chequear();
    }
    
    @Test
    public void badPassTest(){
        pass2 = pass = new Pair("1234567",false);
        chequear();
    }
    
    @Test
    public void badPass2Test(){
        pass2 = new Pair(pass+" ",false);
        chequear();
    }
    
    @Test
    public void badCiudadTest(){
        ciudad = new Pair("",false);
        chequear();
    }
    
    @Test
    public void badCalleTest(){
        calle = new Pair("",false);
        chequear();
    }
    
    @Test
    public void badNumeroTest(){
        numero = new Pair("",false);
        chequear();
    }
    
    @Test
    public void OkPisoVacio(){
        piso = new Pair("",true);
        chequear();
    }
    
    @Test
    public void OkDepartamentoVacio(){
        departamento = new Pair("",true);
        chequear();
    }

    private void chequear() {
        Boolean shouldThrow = !(dni.getValue() && nombre.getValue() && apellido.getValue() && user.getValue() && pass.getValue() && pass2.getValue()
                 && ciudad.getValue() && calle.getValue() && numero.getValue() && piso.getValue() && departamento.getValue());
        try {
            GestorUsuario.darDeAltaUsuario(dni.getKey(), nombre.getKey(), apellido.getKey(), user.getKey(), pass.getKey(),
                    pass2.getKey(), "Operario", ciudad.getKey(), calle.getKey(), numero.getKey(), piso.getKey(), departamento.getKey());
            if (shouldThrow) {
                fail("Se esperaba una excepcion que no fue arrojada");
            }
        } catch (DatosUsuarioException e) {
  
            if (!shouldThrow) {
                fail("No se esperaba un excepcion");
            }

            assertEquals("Fail on DNI " + dni.getKey() + " expected " + dni.getValue() + " got " + e.getDni(), dni.getValue(), e.getDni());
            assertEquals("Fail on NOMBRE " + nombre.getKey() + " expected " + nombre.getValue() + " got " + e.getNombre(), nombre.getValue(), e.getNombre());
            assertEquals("Fail on APELLIDO " + apellido.getKey() + " expected " + apellido.getValue() + " got " + e.getApellido(), apellido.getValue(), e.getApellido());
            assertEquals("Fail on USUARIO " + user.getKey() + " expected " + user.getValue() + " got " + e.getUsuario(), user.getValue(), e.getUsuario());
            assertEquals("Fail on CONTRASENIA " + pass.getKey() + " expected " + pass.getValue() + " got " + e.getPass(), pass.getValue(), e.getPass());
            assertEquals("Fail on CONTRASENIA2 " + pass2.getKey() + " expected " + pass2.getValue() + " got " + e.getPass2(), pass2.getValue(), e.getPass2());
            assertEquals("Fail on CIUDAD " + ciudad.getKey() + " expected " + ciudad.getValue() + " got " + e.getDomicilioException().getCiudad(), ciudad.getValue(), e.getDomicilioException().getCiudad());
            assertEquals("Fail on CALLE " + calle.getKey() + " expected " + calle.getValue() + " got " + e.getDomicilioException().getCalle(), calle.getValue(), e.getDomicilioException().getCalle());
            assertEquals("Fail on NUMERO " + numero.getKey() + " expected " + numero.getValue() + " got " + e.getDomicilioException().getNumero(), numero.getValue(), e.getDomicilioException().getNumero());
            assertEquals("Fail on PISO " + piso.getKey() + " expected " + piso.getValue() + " got " + e.getDomicilioException().getPiso(), piso.getValue(), e.getDomicilioException().getPiso());
            assertEquals("Fail on DEPARTAMENTO " + departamento.getKey() + " expected " + departamento.getValue() + " got " + e.getDomicilioException().getDepartamento(), departamento.getValue(), e.getDomicilioException().getDepartamento());

        }
    }

}
