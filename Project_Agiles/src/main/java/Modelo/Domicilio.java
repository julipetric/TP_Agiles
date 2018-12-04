package Modelo;
// Generated 04/12/2018 19:16:56 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Domicilio generated by hbm2java
 */
public class Domicilio implements java.io.Serializable {

    private Integer uid;
    private String ciudad;
    private String calle;
    private int numero;
    private String departamento;
    private int piso;
    private Set usuarios = new HashSet(0);
    private Set titulars = new HashSet(0);

    public Domicilio() {
    }

    public Domicilio(String ciudad, String calle, int numero, String departamento, int piso) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.piso = piso;
    }

    public Domicilio(String ciudad, String calle, int numero, String departamento, int piso, Set usuarios, Set titulars) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.piso = piso;
        this.usuarios = usuarios;
        this.titulars = titulars;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
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

    public Set getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

    public Set getTitulars() {
        return this.titulars;
    }

    public void setTitulars(Set titulars) {
        this.titulars = titulars;
    }

    public String asString() {
        Integer num = this.getNumero();
        String d = this.getCalle() + ' ' + num.toString() + ", " + this.getCiudad();
        return d;
    }

    @Override
    public String toString() {
        return ciudad + " - " + calle + " " + numero + " Piso: " + piso + " Dpto: " + departamento;
    }

}
