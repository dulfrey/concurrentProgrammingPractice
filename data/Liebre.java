
package data;

public class Liebre extends Animal {
    public Liebre() {
        super();
            this.setNombre("Liebre");
        this.addMovement(new Movement("Salto Largo", 9 , 20));
        this.addMovement(new Movement("Salto Corto", 1 , 30));
        this.addMovement(new Movement("Dormir", 0 , 20));
        this.addMovement(new Movement("Deslizamiento Largo", -12 , 10));
        this.addMovement(new Movement("Deslizamiento Corto", -2 , 20));
    }
    
}
