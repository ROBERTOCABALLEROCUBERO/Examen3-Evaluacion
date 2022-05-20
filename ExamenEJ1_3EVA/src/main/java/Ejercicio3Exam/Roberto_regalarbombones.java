/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio3Exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Roberto_regalarbombones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String, Double> alumnos = new HashMap<>();
        BufferedReader br = null;
        String nombre;
        int numalumnos, bombones, numlineas = 0;
        Scanner leer = new Scanner(System.in);
        //Declaro las variables
        try {
            System.out.println("¿Cuantos alumnos juegan?");
            numalumnos = leer.nextInt();
            System.out.println("¿Cual es el numero maximo de bombones que les pueden tocar?");
            bombones = leer.nextInt();
            //Leo el numero de alumnos
            br = new BufferedReader(new FileReader("C:\\Users\\DAW\\Desktop\\tenerife\\participants.csv"));
            String texto = null;
            while ((texto = br.readLine()) != null && numlineas != numalumnos) {
                String.valueOf(texto);
                String[] dividir = texto.split("\"");
                numlineas++;
                if(dividir.length != 0){
                alumnos.put(dividir[1], Math.random() * bombones);
                }
            }
//Recorro todo el archi y llo meto en el hash map
            System.out.println("Sobre que alumno quieres la información");
            nombre = leer.next();

            if (alumnos.containsKey(nombre)) {
                System.out.printf("Los bombones de %s son %s", nombre, alumnos.get(nombre));
            } else {
                throw new Exception("No hay bombones para ti");
            }
            br.close();
        } catch (FileNotFoundException e) {

            System.out.println("No se ha encontrado el archivo");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
