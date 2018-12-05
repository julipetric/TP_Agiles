package com.JUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Exceptions.DatosLicenciaException;
import Gestores.GestorLicencias;
import Modelo.Licencia;
import Modelo.Titular;
import Modelo.Usuario;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashSet;
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
public class VigenciaLicenciaJUnitTest {
    
    Titular titular;
    Licencia licencia;
    LocalDate fechaNac;
    long unAnio,timeDif;
    
    public VigenciaLicenciaJUnitTest() {
        unAnio = 366*24*3600*100;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        titular = new Titular();
        licencia = new Licencia();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test20Anios1(){
        fechaNac = LocalDate.of(1998, 8, 2);
        cargarDatos();
        assertTrue(timeDif<=unAnio);
        
    }
    
    @Test
    public void test20Anios2(){
        fechaNac = LocalDate.of(1998,8,2);
        cargarDatos();
        titular.getLicencias().add(new Licencia());
        assertTrue(timeDif>2*unAnio && timeDif<=3*unAnio);
    }
    
    @Test
    public void test25Anios(){
        fechaNac = LocalDate.of(1993, 8, 2);
        cargarDatos();
        assertTrue(timeDif>4*unAnio && timeDif<=5*unAnio);
    }
    
    @Test
    public void test50Anios(){
        fechaNac = LocalDate.of(1968, 8, 2);
        cargarDatos();
        assertTrue(timeDif>3*unAnio && timeDif<=4*unAnio);
    }
    
    @Test
    public void test65Anios(){
        fechaNac = LocalDate.of(1953, 8, 2);
        cargarDatos();
        assertTrue(timeDif>2*unAnio && timeDif<=3*unAnio);
    }
    
    @Test
    public void test75Anios(){
        fechaNac = LocalDate.of(1943, 8, 2);
        cargarDatos();
        assertTrue(timeDif<=unAnio);
    }
    
    public void cargarDatos(){
        titular.setFechaNacimiento(Date.valueOf(fechaNac));
        titular.setLicencias(new LinkedHashSet(0));
        try
        {
            licencia = GestorLicencias.crearLicencia(titular, new Usuario(), "A");
            timeDif = licencia.getFechaExpiracion().getTime()-licencia.getFechaTramite().getTime();
        }catch(DatosLicenciaException e){
            fail("No se esparaba un excepcion en los datos de la licencia");
        }
    }
}
    

