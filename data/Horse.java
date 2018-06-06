
package data;

/**
 * Created by Dulfrey on 05/06/2018.
 */


public class Horse extends Animal {
    public Horse() {
        super();
            this.setNombre("Caballo");
        this.addMovement(new Movement("Galopar", 0 , 10));
        this.addMovement(new Movement("Marchar", 10 , 60));
        this.addMovement(new Movement("Descansar", 0 , 30));
        
    }
    
}
