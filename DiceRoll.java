//River Bumpas
//CS110 OL
//Final Project
public class DiceRoll extends Dice {
    
    //Instance Variable
    private final static int NUM_DIE = 5;

    /**
     * Constructor method to fill the parent class with NUM_DIE random Die objects
     */
    public DiceRoll(){
        super(NUM_DIE);
        for (int i = 0; i < NUM_DIE; i++){
            Die a = new Die();
            addDie(a);
        }

    }
    /**
     * Method to roll each of the Die in the Dice ArrayList
     */
    public void toss(){
        for (int i = 0; i < getNumDice(); i++)
        {
            getDie(i).Roll();
        }
    }
}
