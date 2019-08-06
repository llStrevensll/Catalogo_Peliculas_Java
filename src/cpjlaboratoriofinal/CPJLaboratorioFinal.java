/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpjlaboratoriofinal;
import co.com.peliculas.negocio.*;
import java.util.Scanner;
/**
 *
 * @author angue
 */
public class CPJLaboratorioFinal {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\catalogoPeliculas\\peliculas.txt";
    private static final CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
    public static void main(String[] args) {
        while(opcion != 0){
            try{
                System.out.println("Elige opcion:\n1. - Iniciar catalogo peliculas"
                        + "\n2. -Agregar Pelicula\n"
                        + "3. -Listar Peliculas\n"
                        + "4. -Buscar Pelicula\n"
                        + "0. -Salir");
                opcion = Integer.parseInt(scanner.nextLine());
                
                //Switch
                switch (opcion){
                    case 1:
                        //Creacion del objeto que administra el catalogo peliculas
                        //Es opcional puesto que aun asi se creara al escribir por primera vez en el archivo
                        catalogoPeliculas.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //Agregar informacion al archivo
                        System.out.println("Introduce el nombre de una pelicula a agregar:");
                        String nombre = scanner.nextLine();
                        catalogoPeliculas.agregarPelicula(nombre, nombreArchivo);
                    case 3:
                        //Listar catalogo completo
                        catalogoPeliculas.listarPeliculas(nombreArchivo);
                        break;
                    case 4:
                        //Buscar Pelicula
                        System.out.println("Introduce el nombre de una pelicula a buscar:");
                        String buscar = scanner.nextLine();
                        catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                }
                System.out.println("\n");
            }catch(Exception e){
                System.out.println("Error!");
            }
        }
    }
    
}
