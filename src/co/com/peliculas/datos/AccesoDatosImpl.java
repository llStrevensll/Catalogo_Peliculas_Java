/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peliculas.datos;

import co.com.peliculas.domain.*;
import co.com.peliculas.excepciones.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 *
 * @author angue
 */
public class AccesoDatosImpl implements AccesoDatos{
    
    
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();//exists metodo de File-> veifica si existe
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();               
            }
            entrada.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se anexo correctamente la información");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while(linea != null){
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {// Ver si son iguales ignorando las diferencias entre mayúsculas y minúsculas. 
                    resultado = "Pelicula" + linea + " encontrada en indice " + i;//indicar el indice
                    break;
                }
                linea = entrada.readLine();
            }
            entrada.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter (archivo));
            salida.close();
            System.out.println("Se ha creado el archivo correctamente ");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {//Borra el Archivo
         File archivo = new File(nombreArchivo);
         archivo.delete();
         System.out.println("Archivo elminado completamente!");
    }
    
}
