/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import daoescolaridad.DaoEscolaridad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo;
import vista.VistaEscolaridad;

/**
 *
 * @author florm
 */
public class Controlador  implements ActionListener{
    private VistaEscolaridad vista;
    private ArrayList<Object[]> datosLista = new ArrayList<>();

    public Controlador() {
        vista=new VistaEscolaridad();
        vista.setVisible(true);
        vista.getBtnGuardar().addActionListener(this);
        vista.getBtnConsultar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton= e.getSource();
        if(boton.equals(this.vista.getBtnGuardar())){
            
           guardarDatos();
        }
        if(boton.equals(this.vista.getBtnConsultar())){
            mostraTabla();
            System.out.println("holaaaaaaa");
        }
        
    }
    
    public void guardarDatos(){
        
        int id_escuela;
        String escolaridad;
        String nom_escu;
        String grado;
        String nom_Prof;
        String tel_Prof;
        String dire_Escu;
        
        id_escuela=Integer.parseInt(vista.getEntradaIdEscuela().getText());
        escolaridad=vista.getEntradaEscolaridad().getText();
        nom_escu=vista.getEntradaNombEscuela().getText();
        grado=vista.getGrado().getText();
        nom_Prof=vista.getNombreProf().getText();
        tel_Prof=vista.getTelfProfesor().getText();
        dire_Escu=vista.getDirEscuela().getText();
        
        try {
            Modelo objetoModelo=new Modelo(id_escuela, escolaridad, nom_escu, grado, nom_Prof, tel_Prof, dire_Escu);
            DaoEscolaridad varDao= new DaoEscolaridad();
            varDao.insertar(objetoModelo);
            System.out.println("Se agrego");

        } catch (Exception e) {
        }
        
        vista.getEntradaIdEscuela().setText("");
        vista.getEntradaEscolaridad().setText("");
        vista.getEntradaNombEscuela().setText("");
        vista.getGrado().setText("");
        vista.getNombreProf().setText("");
        vista.getTelfProfesor().setText("");
        vista.getDirEscuela().setText("");
        
        
        System.out.println(id_escuela );
        System.out.println(escolaridad);
        System.out.println(nom_escu );
        System.out.println(grado );
        System.out.println( nom_Prof );
        System.out.println(tel_Prof);
        System.out.println(dire_Escu);
        
      
    }
    
    public void mostraTabla(){
        String COLUM []= {"ID_Escuela","Escolaridad","Nombre_Escuela","Grado","Nombre_Profesor","Telefono_Profesor","Direccion_Escuela"};
        DaoEscolaridad varDao= new DaoEscolaridad();
        DefaultTableModel bob= new DefaultTableModel(COLUM,0);
        ArrayList<Object[]> ojo = new ArrayList<>();
        bob.setNumRows(0);
         
        ojo= varDao.consultar();
         for(Object []datitos :ojo){
             
             bob.addRow(datitos);
            
         }
         
         vista.getjTable1().setModel(bob);
         vista.getLabelTotalRegistrad().setText("TOTAL DE REGISTRADOS");
         vista.getTotal_de_Registrados().setText(String.valueOf(bob.getRowCount()));
  
        
    }
    
    
    
}
