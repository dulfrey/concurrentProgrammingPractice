
package businessLogic;

import static businessLogic.RaceController.console;
import data.Animal;
import static java.lang.System.console;
import java.util.ArrayList;
import ui.ConsoleUI;
import data.Movement;


public class RaceController {

    public static Animal animalWinner;
    public static final int totalRacePositions = 20;
    public static ArrayList<String> route;
    public static ConsoleUI console = new ConsoleUI();

    public static void main(String[] args) {
        TortugaThread turtle = new TortugaThread(totalRacePositions);
        BearThread bear = new BearThread(totalRacePositions);
        LiebreThread hare = new LiebreThread(totalRacePositions);
        HorseThread horse= new HorseThread(totalRacePositions);
        console.printMenu();
        int selectedOption = -1;
        while (selectedOption == -1) {
             if (selectedOption == 2) {
             
             }
            try {
                selectedOption = console.getMenuOption();
            } catch (Exception es) {
                console.printError();
              
            }
        if (selectedOption == 2) {
           console.informacion();
            selectedOption = -1;
            console.printMenu();
        }
        }
        if (selectedOption == 1) {
            resetRoute();
            bear.start();
            hare.start();
            turtle.start();
            horse.start();
        }
        
    }
    public static void resetRoute(){
        route=new ArrayList<String>();
        for(int i = 0;i< totalRacePositions;i++){
            route.add("--");
        }
    }
    public static ArrayList<String> createRoute(){
        ArrayList<String> route = new ArrayList<String>();
                for(int i = 0;i< totalRacePositions;i++){
            route.add("--");
        }
                return route;
    }
    public static void markRoutePosition(String animal,int position, Movement movement){
        int prevPosition = route.indexOf(animal);
        if(prevPosition>-1){
            route.set(prevPosition,"--");
        }
        if(position >= totalRacePositions){
            route.set(totalRacePositions -1, animal);
        }else{
            
            route.set(position, animal);
        }
        console.printRoute(animal, route, movement);
    }
    public static void notifyWinner(Animal animal){
        animalWinner=animal;
        console.printWinner(animal);
    }
} 

