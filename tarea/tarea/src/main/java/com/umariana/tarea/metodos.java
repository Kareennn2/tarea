/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.tarea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author Asus
 */
public class metodos {
    ArrayList<Registro> registros = new ArrayList<>();

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }
    
    public static ArrayList<Registro> cargarUsuarios(ServletContext contexto){
     ArrayList<Registro> registros = new ArrayList<>();
    String path = contexto.getRealPath("/data/usuarios.txt");
    File archivo = new File(path);
    
    if (!archivo.exists()) {
        System.out.println("El archivo no existe en la ubicación: " + path);
        return registros;
    }
    
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            // Asume que la clase Registro tiene un constructor adecuado para crear un Registro desde una cadena
            Registro registro = new Registro(linea); 
            registros.add(registro);
        }
        System.out.println("Se leyeron los registros exitosamente desde " + path);
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Ha ocurrido un error al leer el archivo: " + e.getMessage());
    }
    
    return registros;
}
    
    public static void guardarUsuarios(ServletContext contexto, ArrayList<Registro> registros){
     String path = contexto.getRealPath("/data/usuarios.txt");
    File archivo = new File(path);

    try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
        for (Registro registro : registros) {
            String linea = registro.getNombre() + "," + registro.getUsuario() + "," + registro.getContrasenia();
            writer.println(linea);
        }
        System.out.println("Se guardaron los registros exitosamente en " + path);
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Ha ocurrido un error al guardar los registros: " + e.getMessage());
    }
}
    
    public static Registro BuscarPorNombre(String nombre, ArrayList<Registro> registros){
       
        for( Registro i : registros){
                
            if (i.getNombre().equals(nombre)){
                
                return i; // retorna el perro si se encuentra 
            }
        }
        return null; // retorna null si no se encuentra el perro
    }    
}
    

