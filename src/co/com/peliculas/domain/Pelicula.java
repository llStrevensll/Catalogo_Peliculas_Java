/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peliculas.domain;

/**
 *
 * @author angue
 */
public class Pelicula {
    
    private String nombre;
    
    public Pelicula(){    
    }
    
    public Pelicula(String nombre){
        this.nombre = nombre;
    }
    
    public String getPelicula(){
        return this.nombre;
    }
    
    public void setPelicula(String nombre){
        this.nombre = nombre;
    }
    
    public String toString(){
        return this.nombre;
    }
}
