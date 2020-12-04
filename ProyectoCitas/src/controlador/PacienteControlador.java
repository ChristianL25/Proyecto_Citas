/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import java.text.SimpleDateFormat;



public class PacienteControlador implements ActionListener{
    vista.RegpacienteInternalFrame pacienteVista;
    modelo.Paciente pacienteModelo;
    modelo.GestorPaciente gestorpacientesModelo;
    
    
    public PacienteControlador(vista.RegpacienteInternalFrame pacientevista){
    this.pacienteVista=pacientevista;
    gestorpacientesModelo =  new modelo.GestorPaciente();
    }
    @Override
    public void actionPerformed(ActionEvent e){
    if(e.getSource().equals(pacienteVista.Registrar)){
    String identificacion = pacienteVista.Identificacion.getText();
    String nombre = pacienteVista.Nombre.getText();
    String apellido = pacienteVista.Apellido.getText();
       // SimpleDateFormat formato= new SimpleDateFormat("dd/mm/yyyy");
    //String fecha_nacimiento = formato.format(pacienteVista.Fecha)
    
    String  genero="";
        if (pacienteVista.Masculino.isSelected()) {
            genero="M";
        }
        if(pacienteVista.Femenino.isSelected()){
        genero="F";
        }
        pacienteModelo=new modelo.Paciente(identificacion,nombre,apellido,genero);
        gestorpacientesModelo.RegistrarPaciente(pacienteModelo);
    }
   if (e.getSource().equals(pacienteVista.Nuevo)){
   pacienteVista.Identificacion.setText("");
   pacienteVista.Nombre.setText("");
   //pacienteVista.Fecha.setDate("");
   pacienteVista.Masculino.setSelected(true);
   pacienteVista.Femenino.setSelected(false);
   pacienteVista.Identificacion.requestFocus();
   }

    }
}

