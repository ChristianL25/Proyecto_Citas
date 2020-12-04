/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author YEFERSON
 */
public class GestorPacienteControl implements ActionListener {
    modelo.GestorPaciente pacienteModelo;
    vista.ConsPacienteInternalFrame consultarPacienteVista;
     public GestorPacienteControl(vista.ConsPacienteInternalFrame consultarPacientesVista){
     this.consultarPacienteVista=consultarPacientesVista;
     pacienteModelo= new modelo.GestorPaciente();
     }
    public void actionPerformed(ActionEvent e ){
    DefaultTableModel tmodelo;
     
        String valor=consultarPacienteVista.Valor.getText();
        int parametro=0;        
        if(consultarPacienteVista.Identificacion.isSelected()){
        parametro=1;
        }
        if(consultarPacienteVista.Nombre.isSelected()){
            parametro=2;
        }
        if(consultarPacienteVista.Apellido.isSelected()){
            parametro=3;
        }
        if(consultarPacienteVista.Sexo.isSelected()){
        parametro=4;
        }
        LinkedList<modelo.Paciente> pacientes= pacienteModelo.getPacientebyParametro(parametro, valor);
        String registro[]= new String[5];
        String []Titulos = {"Identificacion","Nombre","Apellido","Genero"};
        
        tmodelo=new DefaultTableModel();
        tmodelo.setColumnIdentifiers(Titulos);
        
        for (modelo.Paciente p:pacientes) {
            registro[0]=p.getIdentificacion();
            registro[1]=p.getNombre();
            registro[2]=p.getApellido();
            registro[3]=p.getGenero();
            //registro[4]=p.getFechadenacimiento;
            tmodelo.addRow(registro);
            
        }
    consultarPacienteVista.Tabla.setModel(tmodelo);
    }
}
