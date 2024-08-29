//River Bumpas
//CS110 OL
//Final Project
import java.util.Random;
public class Die {
    //Instance Variables
    private int value;
    private final static int SIDES = 6;
    
    private Random r = new Random(); //Random number generator for the class
    /**
     * Constructor that initializes value to a random number between 1 and SIDES
     */
    public Die(){
        value = r.nextInt(1, SIDES + 1);
    }
    /**
     * Method that changes the value to a random number between 1 and SIDES
     */
    public void Roll(){
        value = r.nextInt(1, SIDES + 1);
    }
    /**
     * Method to return the value on the die
     * @return the value on the die
     */
    public int getValue(){
        return value;
    }
    @Override
    public String toString(){
        return String.format("%d", value);
    }
}


