/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.util.ArrayList;
import modelo.Modelo;

/**
 *
 * @author florm
 */
public interface Interface {
     public boolean insertar(Modelo ob);
    public boolean eliminar(Modelo ob);
    public boolean modificar(Modelo ob);
    public ArrayList<Object[]> consultar();
}
