/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio3Exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

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
        HashMap<String, Integer> alumnos = new HashMap<>();
         BufferedReader br = null;
      
      try {
         
         br =new BufferedReader(new FileReader("files/Libro1.csv"));
         String line = br.readLine();
         while (null!=line) {
            String [] fields = line.split(SEPARATOR);
         }
        } catch (Exception e) {
        }
    
    

    }
}
