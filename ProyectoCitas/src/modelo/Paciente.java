/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author YEFERSON
 */
public class Paciente {
private String identificacion;
private String nombre;
private String apellido;
private String fechaNacimiento;
private String genero;

public Paciente( String identificacion,String nombre,String apellido ,String genero ){
this.identificacion= identificacion;
this.nombre=nombre;
this.apellido=apellido;
//this.fechaNacimiento=fechaNacimiento;
this.genero=genero;
}


public String getIdentificacion(){
return identificacion;
}
public void setIdentificacion(String identificacion ){
this.identificacion=identificacion;
}
public String getNombre(){
return nombre;
}
public void setNombre(String nombre){
this.nombre=nombre;
}
public String getApellido(){
return apellido;
}
public void setApellido(String apellido){
this.apellido=apellido;
}

public String getGenero(){
return genero;
}
public void setGenero(String genero){
this.genero=genero;
}

}
