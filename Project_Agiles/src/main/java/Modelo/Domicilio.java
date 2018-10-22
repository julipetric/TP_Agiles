package Modelo;
// Generated 18/10/2018 19:41:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Domicilio generated by hbm2java
 */
public class Domicilio  implements java.io.Serializable {


     private int uid;
     private String ciudad;
     private String calle;
     private int numero;
     private String departamento;
     private int piso;
     private Set titulars = new HashSet(0);

    public Domicilio() {
    }

	
    public Domicilio(int uid, String ciudad, String calle, int numero, String departamento, int piso) {
        this.uid = uid;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.piso = piso;
    }
    public Domicilio(int uid, String ciudad, String calle, int numero, String departamento, int piso, Set titulars) {
       this.uid = uid;
       this.ciudad = ciudad;
       this.calle = calle;
       this.numero = numero;
       this.departamento = departamento;
       this.piso = piso;
       this.titulars = titulars;
    }
   
    public int getUid() {
        return this.uid;
    }
    
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public int getPiso() {
        return this.piso;
    }
    
    public void setPiso(int piso) {
        this.piso = piso;
    }
    public Set getTitulars() {
        return this.titulars;
    }
    
    public void setTitulars(Set titulars) {
        this.titulars = titulars;
    }

    public String asString(){
        Integer num = this.getNumero();
        String d = this.getCalle() + ' ' + num.toString() + ", " + this.getCiudad();
        return d;
    }


}


