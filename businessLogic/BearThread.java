
package businessLogic;

import data.Bear;
import data.Movement;
import ui.ConsoleUI;
import static java.lang.Thread.sleep;
/**
 * Created by Dulfrey on 05/06/2018.
 */
public class BearThread extends Thread {
    private int totalPositions;
   private Bear bear;
   private String[] bearRoute;
   public BearThread (int totalPositions){
       super();
       this.bear = new Bear();
       this.totalPositions = totalPositions;
       this.bearRoute = new String[totalPositions];
       resetRoute();  
   }
   public void resetRoute(){
       for(int i = 0 ; i < this.bearRoute.length;i++){
           this.bearRoute[i]= "--";
          
       }
   }
      public void setPositionOnRoute(){
       resetRoute(); 
       if(bear.getPosition()>totalPositions-1){
           this.bearRoute[totalPositions-1]= " O ";
       }else{this.bearRoute [bear.getPosition()]= " O ";         
                   }
      
       }    
      public void verifyWinner(){
          if(this.bear.getPosition()>=this.totalPositions&&RaceController.animalWinner == null){
            RaceController.notifyWinner(this.bear) ;
          }
   }
      public void run(){
          ConsoleUI console = new ConsoleUI();
          while(RaceController.animalWinner == null){
             Movement movement = this.bear.computeMovement();
             
             bear.setPosition(bear.getPosition()+ movement.getValue());
             RaceController.markRoutePosition("O", bear.getPosition(),movement);
             
            
             this.verifyWinner();
             try{
                 sleep(500);
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
          }
      }
}


