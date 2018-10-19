/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Daos.UsuarioDao;
import Exceptions.DatosUsuarioInvalidosException;
import Modelo.Usuario;

/**
 *
 * @author lucia
 */
public class GestorSesion {
    private static Usuario usuarioActual;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuarioActual) {
        GestorSesion.usuarioActual = usuarioActual;
    }
    
    public static void iniciarSesion(String nombre, String contra) throws DatosUsuarioInvalidosException {
        Usuario user = UsuarioDao.find(nombre, contra);
        if (user != null) {
            usuarioActual = user;
        } else {
            throw new DatosUsuarioInvalidosException();
        }
    }
    
}
