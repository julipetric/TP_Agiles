package Modelo;
// Generated 18/10/2018 19:41:40 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Licencia generated by hbm2java
 */
public class Licencia  implements java.io.Serializable {


     private Integer uid;
     private Titular titular;
     private Usuario usuario;
     private String clase;
     private Date fechaTramite;
     private Date fechaExpiracion;
     private float costo;

    public Licencia() {
    }

    public Licencia(Titular titular, Usuario usuario, String clase, Date fechaTramite, Date fechaExpiracion, float costo) {
       this.titular = titular;
       this.usuario = usuario;
       this.clase = clase;
       this.fechaTramite = fechaTramite;
       this.fechaExpiracion = fechaExpiracion;
       this.costo = costo;
    }
   
    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Titular getTitular() {
        return this.titular;
    }
    
    public void setTitular(Titular titular) {
        this.titular = titular;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getClase() {
        return this.clase;
    }
    
    public void setClase(String clase) {
        this.clase = clase;
    }
    public Date getFechaTramite() {
        return this.fechaTramite;
    }
    
    public void setFechaTramite(Date fechaTramite) {
        this.fechaTramite = fechaTramite;
    }
    public Date getFechaExpiracion() {
        return this.fechaExpiracion;
    }
    
    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    public float getCosto() {
        return this.costo;
    }
    
    public void setCosto(float costo) {
        this.costo = costo;
    }




}

