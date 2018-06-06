
package businessLogic;

import data.Tortuga;
import data.Movement;
import ui.ConsoleUI;
import static java.lang.Thread.sleep;

public class TortugaThread extends Thread {
    private int totalPositions;
   private Tortuga turtle;
   private String[] turtleRoute;
   public TortugaThread (int totalPositions){
       super();
       this.turtle = new Tortuga();
       this.totalPositions = totalPositions;
       this.turtleRoute = new String[totalPositions];
       resetRoute();  
   }
   public void resetRoute(){
       for(int i = 0 ; i < this.turtleRoute.length;i++){
           this.turtleRoute[i]= "--";
          
       }
   }
      public void setPositionOnRoute(){
       resetRoute(); 
       if(turtle.getPosition()>totalPositions-1){
           this.turtleRoute[totalPositions-1]= " T ";
       }else{this.turtleRoute [turtle.getPosition()]= " T ";         
                   }
      
       }    
      public void verifyWinner(){
          if(this.turtle.getPosition()>=this.totalPositions&&RaceController.animalWinner == null){
            RaceController.notifyWinner(this.turtle) ;
          }
   }
      public void run(){
          ConsoleUI console = new ConsoleUI();
          while(RaceController.animalWinner == null){
             Movement movement = this.turtle.computeMovement();
             
             turtle.setPosition(turtle.getPosition()+ movement.getValue());
             RaceController.markRoutePosition("T", turtle.getPosition(),movement);
             
            
             this.verifyWinner();
             try{
                 sleep(500);
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
          }
      }
}


