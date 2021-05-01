/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Blob;

public class Lalumnos {

    String alumnoId,NoControl,nombre,aPaterno,aMaterno,email,telefono,estado;
    String foto;
    int semestre,carreraId;
    
    
    public Lalumnos(){
    }

    public Lalumnos(String alumnoId, String NoControl, String nombre, String aPaterno, String aMaterno, int semestre, String foto, String telefono,String email, int carreraId,String estado) {
        this.alumnoId = alumnoId;
        this.NoControl = NoControl;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.semestre = semestre;
        this.foto = foto;
        this.telefono = telefono;
        this.email = email;
        this.carreraId = carreraId;
        this.estado = estado;
        
        
    }
    
    

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getNoControl() {
        return NoControl;
    }

    public void setNoControl(String NoControl) {
        this.NoControl = NoControl;
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
    public void setFoto(String foto){
    this.foto=foto;
    }
    public String getFoto() {
        return foto;
    }

    public void String(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(int carreraId) {
        this.carreraId = carreraId;
    }
    
    
}
