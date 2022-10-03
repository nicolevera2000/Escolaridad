/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daoescolaridad;

import java.sql.*;
import conexion.Conexion;
import idao.Interface;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Modelo;

/**
 *
 * @author florm
 */
public class DaoEscolaridad extends Conexion implements Interface{

    @Override
    public boolean insertar(Modelo ob) {
    String insert="insert into escuela(id_escu,escolaridad,nom_escu,grado,nom_prof,tele_prof,dir_escu) values (?,?,?,?,?,?,?)";
    boolean registrar= false;
    
    PreparedStatement sta=null;
        try {
            this.conectar();
            sta=this.con.prepareStatement(insert);
            
            sta.setInt(1, ob.getId_escu());
            sta.setString(2, ob.getEscolaridad());
            sta.setString(3, ob.getNombre_escuela());
            sta.setString(4, ob.getGrado());
            sta.setString(5, ob.getNombre_prof());
            sta.setString(6, ob.getTele_prof());
            sta.setString(7, ob.getDire_Escuela());
            
            sta.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Esta mal el registro sql del insertar"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo en Escuela "
                     + " a ingresado un dato que no existe a esa tabla", "Error", JOptionPane.WARNING_MESSAGE);
            
        Logger.getLogger(DaoEscolaridad.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.desconectar();
            } catch (Exception ex) {
                Logger.getLogger(DaoEscolaridad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrar;
        }

    

    @Override
    public boolean eliminar(Modelo ob) {
    return false;
    }

    @Override
    public boolean modificar(Modelo ob) {
    return false;
    }

    @Override
    public ArrayList<Object[]> consultar() {
        Connection conec= null;
        Statement sta=null;
        PreparedStatement stam=null;
        ResultSet re=null;
         ArrayList<Object[]> listaBen= new ArrayList<>();
         
         String sql="select * from escuela";
         try {
            this.conectar();
            conec=this.getCon();
            sta=conec.createStatement();
            sta.execute(sql);
            sta.close();
            
            stam=conec.prepareStatement(sql);
            re=stam.executeQuery();
            
             while (re.next()) {                 
                 Object[] fila=new Object[7];
                 for (int i = 0; i <=6 ; i++) {
                     fila[i] = re.getObject(i+1);
                 }
                 
                 listaBen.add(fila);
             }
             conec.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR escuela:"+e.getMessage());
        }finally{
             return listaBen;
         }
         
    }

    
    
}
