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
        unAnio = 366L*24L*3600L*1000L;
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
        cargarDatos(false);
        String mensaje = buildMensaje(1);
        assertTrue(mensaje,timeDif<=unAnio);
        
    }
    
    @Test
    public void test20Anios2(){
        fechaNac = LocalDate.of(1998,8,2);
        cargarDatos(true);
        String mensaje = buildMensaje(3);
        assertTrue(mensaje,timeDif>2*unAnio && timeDif<=3*unAnio);
    }
    
    @Test
    public void test25Anios(){
        fechaNac = LocalDate.of(1993, 8, 2);
        cargarDatos(false);
        String mensaje = buildMensaje(5);
        assertTrue(mensaje,timeDif>4*unAnio && timeDif<=5*unAnio);
    }
    
    @Test
    public void test50Anios(){
        fechaNac = LocalDate.of(1968, 8, 2);
        cargarDatos(false);
        String mensaje = buildMensaje(4);
        assertTrue(mensaje,timeDif>3*unAnio && timeDif<=4*unAnio);
    }
    
    @Test
    public void test65Anios(){
        fechaNac = LocalDate.of(1953, 8, 2);
        cargarDatos(false);
        String mensaje = buildMensaje(3);
        assertTrue(mensaje,timeDif>2*unAnio && timeDif<=3*unAnio);
    }
    
    @Test
    public void test75Anios(){
        fechaNac = LocalDate.of(1943, 8, 2);
        cargarDatos(false);
        String mensaje = buildMensaje(1);
        assertTrue(mensaje,timeDif<=unAnio);
    }
    
    public String buildMensaje(int vigenciaEsperada){
        return "Diferencia: "+timeDif+","+(timeDif/unAnio+1)+" y debe ser: "+vigenciaEsperada*unAnio+","+vigenciaEsperada*unAnio/unAnio+
                " Fecha de nacimiento titular: "+ titular.getFechaNacimiento()+
                " Fecha de tramite: "+ licencia.getFechaTramite()+
                " Fecha de vencimiento: "+ licencia.getFechaExpiracion();
    }
    
    public void cargarDatos(boolean tieneLicenciaPrevia){
        titular.setFechaNacimiento(Date.valueOf(fechaNac));
        titular.setLicencias(new LinkedHashSet(0));
        if(tieneLicenciaPrevia) titular.getLicencias().add(new Licencia());
        try
        {
            licencia = GestorLicencias.crearLicencia(titular, new Usuario(), "A");
            timeDif = licencia.getFechaExpiracion().getTime()-licencia.getFechaTramite().getTime();
        }catch(DatosLicenciaException e){
            fail("No se esparaba un excepcion en los datos de la licencia");
        }
    }
}
    

