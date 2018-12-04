package Modelo;
// Generated 18/10/2018 19:41:40 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Titular generated by hbm2java
 */
public class Titular  implements java.io.Serializable {


     private int dni;
     private Domicilio domicilio;
     private String nombre;
     private String apellido;
     private Date fechaNacimiento;
     private String grupoSanguineo;
     private String factorRh;
     private boolean Donante;
     private Set licencias = new HashSet(0);

    public Titular() {
    }

	
    public Titular(int dni, Domicilio domicilio, String nombre, String apellido, Date fechaNacimiento, String grupoSanguineo, String factorRh, boolean esDonante) {
        this.dni = dni;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.grupoSanguineo = grupoSanguineo;
        this.factorRh = factorRh;
        this.Donante = esDonante;
    }
    
    public Titular(String nombre, String apellido, Date fechaNacimiento, String grupoSanguineo, String factorRh, boolean esDonante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.grupoSanguineo = grupoSanguineo;
        this.factorRh = factorRh;
        this.Donante = esDonante;
    }
    
    public Titular(int dni, Domicilio domicilio, String nombre, String apellido, Date fechaNacimiento, String grupoSanguineo, String factorRh, boolean esDonante, Set licencias) {
       this.dni = dni;
       this.domicilio = domicilio;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaNacimiento = fechaNacimiento;
       this.grupoSanguineo = grupoSanguineo;
       this.factorRh = factorRh;
       this.Donante = esDonante;
       this.licencias = licencias;
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
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGrupoSanguineo() {
        return this.grupoSanguineo;
    }
    
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    public String getFactorRh() {
        return this.factorRh;
    }
    
    public void setFactorRh(String factorRh) {
        this.factorRh = factorRh;
    }
    public boolean isEsDonante() {
        return this.Donante;
    }
    
    public void setEsDonante(boolean esDonante) {
        this.Donante = esDonante;
    }
    public Set getLicencias() {
        return this.licencias;
    }
    
    public void setLicencias(Set licencias) {
        this.licencias = licencias;
    }

    @Override
    public String toString() {
        return "Titular{" + "dni=" + dni + ", domicilio=" + domicilio + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", grupoSanguineo=" + grupoSanguineo + ", factorRh=" + factorRh + ", esDonante=" + Donante + ", licencias=" + licencias + '}';
    }




}


