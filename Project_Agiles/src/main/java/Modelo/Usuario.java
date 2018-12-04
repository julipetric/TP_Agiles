package Modelo;
// Generated 04/12/2018 19:16:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int dni;
     private Domicilio domicilio;
     private String nombre;
     private String apellido;
     private String usuarioNombre;
     private String usuarioContrasena;
     private boolean esAdministrador;
     private Set licencias = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int dni, String nombre, String apellido, String usuarioNombre, String usuarioContrasena, boolean esAdministrador) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuarioNombre = usuarioNombre;
        this.usuarioContrasena = usuarioContrasena;
        this.esAdministrador = esAdministrador;
    }
    public Usuario(int dni, Domicilio domicilio, String nombre, String apellido, String usuarioNombre, String usuarioContrasena, boolean esAdministrador, Set licencias) {
       this.dni = dni;
       this.domicilio = domicilio;
       this.nombre = nombre;
       this.apellido = apellido;
       this.usuarioNombre = usuarioNombre;
       this.usuarioContrasena = usuarioContrasena;
       this.esAdministrador = esAdministrador;
       this.licencias = licencias;
    }

    public Usuario(Integer valueOf, String nombre, String apellido, String user, String pass, boolean permisoAdmin, Domicilio domicilio) {
        this.dni = dni;
       this.domicilio = domicilio;
       this.nombre = nombre;
       this.apellido = apellido;
       this.usuarioNombre = user;
       this.usuarioContrasena = pass;
       this.esAdministrador = permisoAdmin;
       this.domicilio = domicilio;
    }
   
    public int getDni() {
        return this.dni;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    public Domicilio getDomicilio() {
        return this.domicilio;
    }
    
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getUsuarioNombre() {
        return this.usuarioNombre;
    }
    
    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
    public String getUsuarioContrasena() {
        return this.usuarioContrasena;
    }
    
    public void setUsuarioContrasena(String usuarioContrasena) {
        this.usuarioContrasena = usuarioContrasena;
    }
    public boolean isEsAdministrador() {
        return this.esAdministrador;
    }
    
    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
    public Set getLicencias() {
        return this.licencias;
    }
    
    public void setLicencias(Set licencias) {
        this.licencias = licencias;
    }




}


