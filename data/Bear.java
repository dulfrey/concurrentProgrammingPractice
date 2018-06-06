
package data;

/**
 * Created by Dulfrey on 05/06/2018.
 */


public class Bear extends Animal {
    public Bear() {
        super();
            this.setNombre("Oso");
        this.addMovement(new Movement("Comer miel", 0 , 30));
        this.addMovement(new Movement("Marchar", 6 , 40));
        this.addMovement(new Movement("Dormir", 0 , 10));
        this.addMovement(new Movement("Carga", 15 , 20));
    }
    
}
