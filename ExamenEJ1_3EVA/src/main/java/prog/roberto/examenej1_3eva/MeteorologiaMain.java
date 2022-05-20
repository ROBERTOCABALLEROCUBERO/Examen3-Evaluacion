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
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String[] notas;
        Integer suma_max = 0, suma_min = 0;
        Scanner leer = null;
        String archivo;
        String fecha;
        double diferencia_inicial = 0, temperatura_max_max = 0, temperatura_max_min = 0,
                temperatura_min_max = 0, temperatura_min_min = 0;
        long numlineas = 0;
        try {
            System.out.println("Introduce el nombre del archivo");
            archivo = leer.next();
            File ruta = new File("C:\\Users\\DAW\\Desktop\\tenerife\\" + archivo);
            leer = new Scanner(ruta);
            while (leer.hasNextLine()) {
                numlineas++;
                String[] Temperaturas = leer.nextLine().split(" ");
                ArrayList<Integer> nuevo = new ArrayList();

                for (int i = 1; i < Temperaturas.length; i++) {

                    suma_max = suma_max + Integer.parseInt(Temperaturas[1]);
                    suma_min = suma_min + Integer.parseInt(Temperaturas[2]);

                    if (diferencia_inicial == 0) {
                        diferencia_inicial = Integer.parseInt(Temperaturas[1]) - Integer.parseInt(Temperaturas[2]);
                    }
                    if (diferencia_inicial < Integer.parseInt(Temperaturas[1]) - Integer.parseInt(Temperaturas[2])) {

                        diferencia_inicial = Integer.parseInt(Temperaturas[1]) - Integer.parseInt(Temperaturas[2]);
                        fecha = Temperaturas[0];

                    }
                    if (temperatura_max_max == 0) {
                        temperatura_max_max = Integer.parseInt(Temperaturas[1]);
                        temperatura_max_min = Integer.parseInt(Temperaturas[1]);
                        temperatura_min_max = Integer.parseInt(Temperaturas[2]);
                        temperatura_min_min = Integer.parseInt(Temperaturas[2]);
                    }

                    if (temperatura_max_max < Integer.parseInt(Temperaturas[1])) {
                        temperatura_max_max = Integer.parseInt(Temperaturas[1]);
                    } else {
                        if (temperatura_max_min > Integer.parseInt(Temperaturas[1])) {
                            temperatura_max_min = Integer.parseInt(Temperaturas[1]);
                        }
                    }
                    if (temperatura_min_max < Integer.parseInt(Temperaturas[2])) {
                        temperatura_min_max = Integer.parseInt(Temperaturas[2]);
                    } else {
                        if (temperatura_min_min > Integer.parseInt(Temperaturas[1])) {
                            temperatura_max_min = Integer.parseInt(Temperaturas[1]);
                        }
                    }

                }

            }
            System.out.printf("Temperatura maxima mas alta y mas baja: %s     %s", temperatura_max_max, temperatura_max_min);
            System.out.printf("Temperatura minima mas alta y mas baja: %s     %s", temperatura_min_max, temperatura_min_min);
            System.out.printf("Temperatura maxima media: %s    ", suma_max / numlineas);
            System.out.printf("Temperatura minima media: %s    ", suma_min / numlineas);
            System.out.printf("Temperatura intermedia: %s    ", (((suma_max / numlineas) + (suma_min / numlineas)) / 2));
            System.out.printf("Mayor diferencia de temperatura: %s %s");
            

            leer.close();
        } catch (FileNotFoundException a) {

            System.out.println("Archivo no encontrado");

        }
    }

}
