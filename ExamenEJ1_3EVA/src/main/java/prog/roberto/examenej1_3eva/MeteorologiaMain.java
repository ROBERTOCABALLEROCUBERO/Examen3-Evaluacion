/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog.roberto.examenej1_3eva;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class MeteorologiaMain {

    /**
     * @param args the command line arguments
     */
    //Lanza la excepcion FileNotFoundException
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        /*
        
        Declaro un array de Strings donde almacenare el resultado del split de cada linea que tiene la misma estructura.
        La variable archivo será la que se tengo que introducir para que me lleve al fichero
        Las variables suma_max y suma_min son para acumular y hacer luego la media de las temperaturas maximas y minimas
        La fecha será el String donde almacenare la fecha con la mayor diferencia de temperatura entre maxima y minima
        El resto de variables seran los datos leidos de cada linea, concretamente en la posicion 1 y 2 de mi array de Temperaturas.
        Por ultimo un long para contar la lineas y ejecutar la media de temperaturas.
         */

        Double suma_max = 0.0, suma_min = 0.0;
        Scanner leer = null;
        String archivo;
        String fecha = null;
        double diferencia_inicial = 0, temperatura_max_max = 0, temperatura_max_min = 0,
                temperatura_min_max = 0, temperatura_min_min = 0;
        long numlineas = 0;
//------------------------------------------------------------------------------------------------------------------------------------
        try {
            Scanner leer2 = new Scanner(System.in);
            System.out.println("Introduce el nombre del archivo");
            archivo = leer2.nextLine();
            //Leo el archivo
            File ruta = new File("C:\\Users\\DAW\\Desktop\\tenerife\\" + archivo);
            leer = new Scanner(ruta);
            //Lo introduzco dentro de un Scanner para recorrerlo.
            while (leer.hasNextLine()) {
                //Cuento las lineas hasta que se acaben en el archivo
                numlineas++;
                String[] Temperaturas = leer.nextLine().split(" ");
                //Divido cada linea y lo almaceno constantemente en un array nuevo que es de Temperaturas.

                suma_max = suma_max + Double.parseDouble(Temperaturas[1]);
                suma_min = suma_min + Double.parseDouble(Temperaturas[2]);
                //La posicion 1 sera de maximas y la 2 de minimas, ademas la primera es la fecha.

                if (diferencia_inicial == 0) {
                    diferencia_inicial = Double.parseDouble(Temperaturas[1]) - Double.parseDouble(Temperaturas[2]);
                    //Inicializo la diferencia
                }
                if (diferencia_inicial <= Double.parseDouble(Temperaturas[1]) - Double.parseDouble(Temperaturas[2])) {

                    diferencia_inicial = Double.parseDouble(Temperaturas[1]) - Double.parseDouble(Temperaturas[2]);
                    fecha = Temperaturas[0];
                    //Asigno la fecha, ademas de comparar las diferencias para quedarme con la maxima.

                }
                if (temperatura_max_max == 0) {
                    temperatura_max_max = Double.parseDouble(Temperaturas[1]);
                    temperatura_max_min = Double.parseDouble(Temperaturas[1]);
                    temperatura_min_max = Double.parseDouble(Temperaturas[2]);
                    temperatura_min_min = Double.parseDouble(Temperaturas[2]);
                    //Inicializo todas las temperaturas maximas y minimas.
                }

                if (temperatura_max_max < Double.parseDouble(Temperaturas[1])) {
                    temperatura_max_max = Double.parseDouble(Temperaturas[1]);
                } else {
                    if (temperatura_max_min > Double.parseDouble(Temperaturas[1])) {
                        temperatura_max_min = Double.parseDouble(Temperaturas[1]);
                    }
                }
                //Comparo para quedarme con la maxima mas alta y con la minima mas baja.

                if (temperatura_min_max < Double.parseDouble(Temperaturas[2])) {
                    temperatura_min_max = Double.parseDouble(Temperaturas[2]);
                } else {
                    if (temperatura_min_min > Double.parseDouble(Temperaturas[1])) {
                        temperatura_max_min = Double.parseDouble(Temperaturas[1]);
                    }
                }
                //Comparo para quedarme con la minima mas alta y con la minima mas baja.

            }
            System.out.println("Temperatura maxima mas alta y mas baja:  " + temperatura_max_max + " " + temperatura_max_min);
            System.out.println("Temperatura minima mas alta y mas baja:  " + temperatura_min_max + " " + temperatura_min_min);
            System.out.println("Temperatura maxima media: " + suma_max / numlineas);
            System.out.println("Temperatura minima media: " + suma_min / numlineas);
            System.out.println("Temperatura intermedia: " + (((suma_max / numlineas) + (suma_min / numlineas)) / 2));
            System.out.println("Mayor diferencia de temperatura: " + diferencia_inicial + "\tEn la fecha: " + fecha);
//Lo imprimo todo
            leer.close();
            //cierro el Scanner.

        } catch (FileNotFoundException a) {

            System.out.println("Archivo no encontrado");

        } catch (NumberFormatException e) {

            System.out.println("El numero que se ha registrado no es decimal");
        } catch (Exception b) {
            System.out.println("Ha ocurrido un error");
        }
        //Controlo las excepciones
    }

}
