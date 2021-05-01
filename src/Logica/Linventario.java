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
public class Linventario {
    
    String idUnico;
    String estado;
    int idLibro;
    
    
    public Linventario(){
    
    }

    public Linventario(String idUnico,int idLibro) {
        this.idUnico = idUnico;
        this.estado = estado;
        this.idLibro = idLibro;
    }
    
    public String getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(String idUnico) {
        this.idUnico = idUnico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
}
