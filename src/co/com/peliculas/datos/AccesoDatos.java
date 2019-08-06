/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peliculas.datos;

import co.com.peliculas.domain.*;
import co.com.peliculas.excepciones.*;
import java.util.*;

/**
 *
 * @author angue
 */
public interface AccesoDatos {
    
    public boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
    
}
