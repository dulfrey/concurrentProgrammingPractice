
package data;


import java.util.ArrayList;
import java.util.Random;
public class Animal {
    private String nombre;
    private ArrayList<Movement> movements;
    private int position;
    public Animal() {
    this.movements = new ArrayList<Movement>();
    this.position = 0;  
}
 public Movement computeMovement(){
     Random random  = new Random();
     int randomNumber = random.nextInt(100)+1;
     int rangeLimit = 0;
     for(Movement movement : getMovements()){
         int lowerLimit = rangeLimit +1;
         rangeLimit += movement.getProbability();
         if(randomNumber>= lowerLimit && randomNumber<=rangeLimit){
         return movement;
     }
     }
     return null;
 }
    public void addMovement(Movement movement){
        this.getMovements().add(movement);
    }

    
    public int getPosition() {
        return position;
    }

   
    public void setPosition(int position) {
        this.position = position;
        if(position<0){
            this.position=0;
        }
    } 

 
    public ArrayList<Movement> getMovements() {
        return movements;
    }

    
    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
