
package businessLogic;

import data.Horse;
import data.Movement;
import ui.ConsoleUI;
import static java.lang.Thread.sleep;
/**
 * Created by Dulfrey on 05/06/2018.
 */

public class HorseThread extends Thread {
    private int totalPositions;
   private Horse horse;
   private String[] horseRoute;
   public HorseThread (int totalPositions){
       super();
       this.horse = new Horse();
       this.totalPositions = totalPositions;
       this.horseRoute = new String[totalPositions];
       resetRoute();  
   }
   public void resetRoute(){
       for(int i = 0 ; i < this.horseRoute.length;i++){
           this.horseRoute[i]= "--";
          
       }
   }
      public void setPositionOnRoute(){
       resetRoute(); 
       if(horse.getPosition()>totalPositions-1){
           this.horseRoute[totalPositions-1]= " C ";
       }else{this.horseRoute [horse.getPosition()]= " C ";         
                   }
      
       }    
      public void verifyWinner(){
          if(this.horse.getPosition()>=this.totalPositions&&RaceController.animalWinner == null){
            RaceController.notifyWinner(this.horse) ;
          }
   }
      public void run(){
          ConsoleUI console = new ConsoleUI();
          while(RaceController.animalWinner == null){
             Movement movement = this.horse.computeMovement();
             
             horse.setPosition(horse.getPosition()+ movement.getValue());
             RaceController.markRoutePosition("C", horse.getPosition(),movement);
             
            
             this.verifyWinner();
             try{
                 sleep(500);
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
          }
      }
}


