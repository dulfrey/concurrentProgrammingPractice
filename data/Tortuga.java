
package data;


public class Tortuga extends Animal{
public Tortuga(){
     super();
           this.setNombre("Tortuga");
        this.addMovement(new Movement("Avance Rapido", 3 , 50));
        this.addMovement(new Movement("Resbalar", -6 , 20));
        this.addMovement(new Movement("Avance Lento", 1 , 30));
      
}
}