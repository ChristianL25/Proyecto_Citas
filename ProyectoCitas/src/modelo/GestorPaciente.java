/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import  java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import recursos.Conexion;
/**
 *
 * @author YEFERSON
 */
public class GestorPaciente {
    private static LinkedList<Paciente> pacientes;
    Connection con;
    Conexion conectar = new Conexion();
    public GestorPaciente(){
    pacientes=new LinkedList<Paciente>();
    }
    public void RegistrarPaciente(Paciente paciente){
    PreparedStatement pst;
        try {
            con= conectar.getConection();
            pst = con.prepareStatement("insert into pacientes values(?,?,?,?)");
            pst.setString(1,paciente.getIdentificacion());
            pst.setString(2,paciente.getNombre());
            pst.setString(3, paciente.getApellido());
           // pst.setString(4,paciente.getFechadeNacimeito());
            pst.setString(4, paciente.getGenero());
            pst.executeUpdate();
            JOptionPane.showInputDialog(null,"Paciente Registrado");
        } catch (SQLException ex) {
            Logger.getLogger(GestorPaciente.class.getName()).log(Level.SEVERE,null,ex);
        }

        pacientes.add(paciente);
    
    }
    public LinkedList<Paciente> getPacientebyParametro(int parametro, String valor ){
    con = conectar.getConection();
    LinkedList<Paciente> resultado = new LinkedList<Paciente>();
    String sql="";
        for (Paciente pac:pacientes) {
            
            switch(parametro){
                case 1: if(pac.getIdentificacion().equals(valor))
            sql="select * from paciente where PacIdentificacion='"+valor+"'";
                resultado.add(pac);
                break;
                   case 2: if(pac.getNombre().equals(valor))
            sql="select * from paciente where PacNombre='"+valor+"'";
                resultado.add(pac);
                break;
                   case 3: if(pac.getApellido().equals(valor))
            sql="select * from paciente where PacApellido='"+valor+"'";
                resultado.add(pac);
                break;
                   case 4: if(pac.getGenero().equals(valor))
            sql="select * from paciente where PacSexo='"+valor+"'";
                resultado.add(pac);
                break;
                
            }
        }
        try {
            try(Statement st=con.createStatement()){
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            resultado.add(new Paciente(rs.getString("PacIdentificacion"),rs.getString("PacNombre"),rs.getString("PacApellido"),rs.getString("PacGenero")));
            
            }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
            }
}
