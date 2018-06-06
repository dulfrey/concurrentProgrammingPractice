
package businessLogic;

import data.Liebre;
import data.Movement;
import ui.ConsoleUI;
import static java.lang.Thread.sleep;

public class LiebreThread extends Thread {
   private int totalPositions;
   private Liebre hare;
   private String[] hareRoute;
   public LiebreThread (int totalPositions){
       super();
       this.hare = new Liebre();
       this.totalPositions = totalPositions;
       this.hareRoute = new String[totalPositions];
       resetRoute();  
   }
   public void resetRoute(){
       for(int i = 0 ; i < this.hareRoute.length;i++){
           this.hareRoute[i]= "--";
          
       }
   }
      public void setPositionOnRoute(){
       resetRoute(); 
       if(hare.getPosition()>totalPositions-1){
           this.hareRoute[totalPositions-1]= " L ";
       }else{this.hareRoute [hare.getPosition()]= " L ";         
                   }
      
       }    
      public void verifyWinner(){
          if(this.hare.getPosition()>=this.totalPositions&&RaceController.animalWinner== null){
            RaceController.notifyWinner(this.hare) ;
          }
   }
      public void run(){
          ConsoleUI console = new ConsoleUI();
          while(RaceController.animalWinner == null){
             Movement movement = this.hare.computeMovement();
           
             hare.setPosition(hare.getPosition()+ movement.getValue());
             RaceController.markRoutePosition("L", hare.getPosition(),movement);
            
             this.verifyWinner();
             try{
                 sleep(500);
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
          }
      }
}
