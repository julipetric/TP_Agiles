/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JUnit;

import Exceptions.DatosUsuarioException;
import Gestores.GestorUsuario;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;
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

    ArrayList<Pair<String, Boolean>> dnis, nombres, apellidos, users, passs, permisos, ciudades, calles, numeros, pisos, departamentos;
    Pair<String, Boolean> dni, nombre, apellido, user, pass, pass2, permiso, ciudad, calle, numero, piso, departamento;
    Random r;

    //Aqui agregamos posibles valores de cada campo
    public UsuarioJUnitTest() {
        r = new Random();
        String bigNum, bigWord;
        bigNum = new String();
        bigWord = new String();
        for (int i = 0; i < 1000; i++) {
            bigNum = bigNum.concat("2");
        }
        for (int i = 0; i < 1000; i++) {
            bigWord = bigWord.concat("a");
        }
        dnis = new ArrayList();
        nombres = new ArrayList();
        apellidos = new ArrayList();
        users = new ArrayList();
        passs = new ArrayList();
        permisos = new ArrayList();
        ciudades = new ArrayList();
        calles = new ArrayList();
        numeros = new ArrayList();
        pisos = new ArrayList();
        departamentos = new ArrayList();

        dnis.add(new Pair("39717462", true));
        dnis.add(new Pair("10", false));
        dnis.add(new Pair("1123456789", false));
        dnis.add(new Pair("1234567", true));
        dnis.add(new Pair("03971746",false));
        dnis.add(new Pair(bigNum, false));

        nombres.add(new Pair("Matias Gabriel", true));
        nombres.add(new Pair("Sol", true));
        nombres.add(new Pair(bigWord,false));//ROMPE
        nombres.add(new Pair("", false));

        apellidos.add(new Pair("Matias Gabriel", true));
        apellidos.add(new Pair("Sol", true));
        apellidos.add(new Pair(bigWord,false)); //ROMPE
        apellidos.add(new Pair("", false));

        users.add(new Pair("Matias Gabriel", true)); //checkear espacio
        users.add(new Pair("Sol", true));
        users.add(new Pair(bigWord, false));
        users.add(new Pair("", false));

        passs.add(new Pair("Matias Gabriel", true)); //checkear espacio
        passs.add(new Pair("Sol",true)); //ROMPE
        passs.add(new Pair(bigWord,false)); // ROMPE
        passs.add(new Pair("", false));

        permisos.add(new Pair("Operario", true));
        permisos.add(new Pair("Administrador", true));

        ciudades.add(new Pair("Matias Gabriel", true));
        ciudades.add(new Pair("Sol", true));
        ciudades.add(new Pair(bigWord, false));
        ciudades.add(new Pair("", false));

        calles.add(new Pair("Matias Gabriel", true));
        calles.add(new Pair("Sol", true));
        calles.add(new Pair(bigWord, false));
        calles.add(new Pair("", false));

        numeros.add(new Pair("000", false));
        numeros.add(new Pair("", false));
        numeros.add(new Pair("123", true));
        numeros.add(new Pair("1", true));
        numeros.add(new Pair(bigNum, false));

        pisos.add(new Pair("1", true));
        pisos.add(new Pair("2", true));
        pisos.add(new Pair(bigNum, false));

        departamentos.add(new Pair("H", true));
        departamentos.add(new Pair("2", true));
        departamentos.add(new Pair(bigNum, false));
        departamentos.add(new Pair(bigWord, false));

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    //Aqui se asignan de forma aleatoria el valor de cada campo, entre los posibles.
    @Before
    public void setUp() {
        dni = dnis.get(r.nextInt(dnis.size()));
        nombre = nombres.get(r.nextInt(nombres.size()));
        apellido = apellidos.get(r.nextInt(apellidos.size()));
        user = users.get(r.nextInt(users.size()));
        pass = passs.get(r.nextInt(passs.size()));
        if (r.nextBoolean() && pass.getValue()) {
            pass2 = new Pair(pass.getKey() + "a", false);
        } else if (pass.getValue()) {
            pass2 = new Pair(pass.getKey(), true);
        } else {
            pass2 = new Pair("asd", true);
        }
        permiso = permisos.get(r.nextInt(permisos.size()));
        ciudad = ciudades.get(r.nextInt(ciudades.size()));
        calle = calles.get(r.nextInt(calles.size()));
        numero = numeros.get(r.nextInt(numeros.size()));
        piso = pisos.get(r.nextInt(pisos.size()));
        departamento = departamentos.get(r.nextInt(departamentos.size()));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void usuarioTest() {
        Boolean shouldThrow = !(dni.getValue() && nombre.getValue() && apellido.getValue() && user.getValue() && pass.getValue() && pass2.getValue()
                && permiso.getValue() && ciudad.getValue() && calle.getValue() && numero.getValue() && piso.getValue() && departamento.getValue());
        try {
            GestorUsuario.darDeAltaUsuario(dni.getKey(), nombre.getKey(), apellido.getKey(), user.getKey(), pass.getKey(),
                    pass2.getKey(), permiso.getKey(), ciudad.getKey(), calle.getKey(), numero.getKey(), piso.getKey(), departamento.getKey());
            if (shouldThrow) {
                fail("Se esperaba una excepcion que no fue arrojada");
            }
        } catch (DatosUsuarioException e) {
            /* System.out.println(dni);
            System.out.println(nombre);
            System.out.println(apellido);
            System.out.println(user);
            System.out.println(pass);
            System.out.println(pass2);
            System.out.println(permiso);
            System.out.println(ciudad);
            System.out.println(calle);
            System.out.println(numero);
            System.out.println(piso);
            System.out.println(departamento);*/

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

        // TODO add test methods here.
        // The methods must be annotated with annotation @Test. For example:
        //
        // @Test
        // public void hello() {}
    }

}
