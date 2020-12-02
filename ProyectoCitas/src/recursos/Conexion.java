/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author YEFERSON
 */
public class Conexion {
    String url="jdbc:mysql://localhost:3306/db_citas";
    String user="root", pass="";
    Connection con;
    public Connection getConection(){
    try {
    Class.forName("com.mysql.jdbc.driver");
    con=DriverManager.getConnection(url,user,pass);
    JOptionPane.showMessageDialog(null,"Conexion a la base de datos");
    }
    catch(Exception e){
    JOptionPane.showConfirmDialog(null, "error de la conexion");
    }
      return con;
    }
  
}
