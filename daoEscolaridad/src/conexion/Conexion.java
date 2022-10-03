/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.*;
/**
 *
 * @author florm
 */
public class Conexion {
    
     public Connection con;
    
    static String usuario = "postgres";
    static String contrasena = "nini";
    static String base = "pruebavinculacion";
    static String cadenaConexion = "jdbc:postgresql://localhost:5432/"+base+"?"+ "user="+usuario+"&password="+contrasena;

    public Conexion(Connection conexion) {
        this.con = conexion;
    }

    public Conexion() {
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

     public Connection conectar() throws ClassNotFoundException, Exception{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(cadenaConexion);
        return con;
    }
    
    public void desconectar() throws Exception{
        try {
            if(con!=null){
                if(con.isClosed()==false){
                    con.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }



}
