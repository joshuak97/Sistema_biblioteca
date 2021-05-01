/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author USUARIO
 */
public class Lusuarios {
    int idUsuario;
    String nombre,aPaterno,aMaterno,usuario,telefono,correo,perfil,clave,preguntaSeguridad,respuestaPS,estado;

    
    public Lusuarios(){
    }
    public Lusuarios(int idUsuario,String nombre, String aPaterno, String aMaterno, String usuario, String telefono, String correo, String perfil, String preguntaSeguridad, String respuestaPS) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.usuario = usuario;
        this.telefono = telefono;
        this.correo = correo;
        this.perfil = perfil;
        this.preguntaSeguridad = preguntaSeguridad;
        this.respuestaPS = respuestaPS;
    }
    
     public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

  
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    public void setPreguntaSeguridad(String preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    public String getRespuestaPS() {
        return respuestaPS;
    }

    public void setRespuestaPS(String respuestaPS) {
        this.respuestaPS = respuestaPS;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 
    
}
