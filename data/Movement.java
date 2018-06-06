
package data;

public class Movement {
   private String name;
   private int value;
   private int probability;
   public Movement(String name, int value, int probability){
       super();
       this.name = name;
       this.value = value;
       this.probability = probability;
      
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}
