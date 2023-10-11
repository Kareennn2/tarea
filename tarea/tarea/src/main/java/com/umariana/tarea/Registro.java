package com.umariana.tarea;
import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Registro implements Serializable{
   //declarar variables 
    private String nombre;
    private String usuario;
    private String contrasenia;

public Registro(String linea){
    String [] partes = linea.split(",");
     if (partes.length == 3) { // Asegurarse de que haya tres partes
        this.nombre = partes[0].trim();
        this.usuario = partes[1].trim();
        this.contrasenia = partes[2].trim();
    }
    
}

    
    public Registro(String nombre, String usuario, String contrasenia){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
       
        
    }
//get para acceder a lo atributos

    public String getNombre() {
        return nombre;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
   
    
    
    
    //set para acceder a los atributoss

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
    
}
