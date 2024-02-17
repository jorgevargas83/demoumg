/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apppacientes.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Conexion {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    Connection con;
    Statement stmt = null;
    String Base = "UMG";
    String DB_URL = "jdbc:mysql://localhost:3306/"+Base+"?useSSL=false&serverTimezone=UTC";
    static final String user = "root";
    static final String pass = "1234";
    
    public Conexion() throws SQLException {
   
        try{
            con = DriverManager.getConnection(DB_URL,user,pass);
        } catch(Exception ex){
            System.out.println("Error al conectarme por: "+ex.getMessage());
        }
        
    }
    
    public void guardarPacientes(Pacientes paciente){
        try{
            if(con!=null){
                PreparedStatement st = con.prepareStatement("insert into pacientes(nombre, direccion, telefono) values(?,?,?)" );
                st.setString(1, paciente.getNombre());
                st.setString(2, paciente.getDireccion());
                st.setString(3, paciente.getTelefono());
                st.execute();
            } else{
                System.out.println("No fue posible guardar el paciente");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al guardar el paciente"+ex.getMessage());
        }
    }
    
    public boolean actualizarPacientes(Pacientes paciente, int id_paciente){
        boolean res = false;
        try{
            if(con!=null){
                PreparedStatement st = con.prepareStatement("update pacientes set nombre=?, direccion=?, telefono=? where id="+id_paciente );
                st.setString(1, paciente.getNombre());
                st.setString(2, paciente.getDireccion());
                st.setString(3, paciente.getTelefono());
                st.executeUpdate();
                res = true;
            } else{
                res = false;
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar el paciente"+ex.getMessage());
        }
        return res;
    }
    
}
