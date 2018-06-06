
package ui;

import data.Animal;
import data.Movement;
import java.util.ArrayList;
import java.util.Scanner;


public class ConsoleUI {

    public void printMenu(){
        System.out.println("Bienvenido a la carrera mas esperada"+
                "en todo el mundo!!!!");
        System.out.println("ANIMAL'S RACE!!!!");
        System.out.println("0. Salir");
        System.out.println("1. Empezar Carrera");
        System.out.println("2. Informacion");
    }

    public int getMenuOption(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printWinner (Animal animalWinner){
       synchronized (this){
           System.out.println();
            System.out.println("-------------------------------------------------------------");
             System.out.println("Y el animal ganador es: "+
                     animalWinner.getNombre()+" !!!!!");
       }
        
    }

    public void informacion (){
        System.out.println("------------------------------------------------------------------------------\n"+
                           "Esta es una simulación enjava de la famosa fábula “La liebre y la tortuga con \n"+
                           "algunas variaciones. La carrera será cuesta arriba en una colina resbaladiza, \n"+
                           "por lo tanto los participantes pueden tando avanzar como retroceder.\n"+
                                        "Christian Fernando Ortiz Pulido (Codigo funcional e Interfaz)\n"               
                         + "------------------------------------------------------------------------------\n");
    }

    public void printError(){
        System.out.println("Error Inserte una opcion correcta");
    }
 
    public void printRoute ( String animal, ArrayList<String> route, Movement movement){
     synchronized (this)  {
          System.out.println("____________________________________________________________");
    switch(animal){
             case "T":
             System.out.println("Tortuga");
             break;
             case "L":
             System.out.println("Liebre");
             break;
             case"O":
                 System.out.println("Oso");
             break;
             case"C":
                     System.out.println("Caballo");
             break;
    }
    System.out.println("Movimiento: "+ movement.getName()+
            " Valor: "+ movement.getValue());
   
             System.out.println("Ruta: ");
             for(String position : route){
                 System.out.print(" "+position+" ");
             
     }
        
             System.out.println();
     } 
    }
}
