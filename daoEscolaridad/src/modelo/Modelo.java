/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author florm
 */
public class Modelo {
   private int id_escu;
   private String escolaridad;
   private String nombre_escuela;
   private String grado;
   private String nombre_prof;
   private String tele_prof;
   private String dire_Escuela;

    public Modelo(int id_escu, String escolaridad, String nombre_escuela, String grado, String nombre_prof, String tele_prof, String dire_Escuela) {
        this.id_escu = id_escu;
        this.escolaridad = escolaridad;
        this.nombre_escuela = nombre_escuela;
        this.grado = grado;
        this.nombre_prof = nombre_prof;
        this.tele_prof = tele_prof;
        this.dire_Escuela = dire_Escuela;
    }

    public int getId_escu() {
        return id_escu;
    }

    public void setId_escu(int id_escu) {
        this.id_escu = id_escu;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getNombre_escuela() {
        return nombre_escuela;
    }

    public void setNombre_escuela(String nombre_escuela) {
        this.nombre_escuela = nombre_escuela;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombre_prof() {
        return nombre_prof;
    }

    public void setNombre_prof(String nombre_prof) {
        this.nombre_prof = nombre_prof;
    }

    public String getTele_prof() {
        return tele_prof;
    }

    public void setTele_prof(String tele_prof) {
        this.tele_prof = tele_prof;
    }

    public String getDire_Escuela() {
        return dire_Escuela;
    }

    public void setDire_Escuela(String dire_Escuela) {
        this.dire_Escuela = dire_Escuela;
    }

    @Override
    public String toString() {
        return "Modelo{" + "id_escu=" + id_escu + ", escolaridad=" + escolaridad + ", nombre_escuela=" + nombre_escuela + ", grado=" + grado + ", nombre_prof=" + nombre_prof + ", tele_prof=" + tele_prof + ", dire_Escuela=" + dire_Escuela + '}';
    }
   
    
}
