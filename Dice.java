//River Bumpas
//CS110 OL
//Final Project
import java.util.ArrayList;
public class Dice{
    
    //Instance Variables
    private ArrayList<Die> dice;
    private final static int DEF_CAP = 5;

    /**
     * Constructor that creates the ArrayList with DEF_CAP capacity
     */
    public Dice(){
        dice = new ArrayList<>(DEF_CAP);
    }
    /**
     * Constructor that creates the ArrayList with a given capacity
     * @param num capacity of ArrayList
     */
    public Dice(int num){
        dice = new ArrayList<>(num);
    }
    /**
     * Method to add a Die to the end of the ArrayList
     * @param d Die to add
     */
    public void addDie(Die d){
        dice.add(d);
    }
    /**
     * Method to return the number of Die in the ArrayList
     * @return number of Die
     */
    public int getNumDice(){
        return dice.size();
    }
    /**
     * Method to return the Die at the given index
     * @param i index of Die
     * @return Die at index i
     */
    public Die getDie(int i){
        return dice.get(i);
    }
    /**
     * Method to remove the Die at the given index
     * @param i index of Die
     */
    public void removeDie(int i){
        dice.remove(i);
    }
    /**
     * Method to return the number of Die in the ArrayList with the specified value
     * @param val value to check for
     * @return the number of times the value was found
     */
    public int count(int val){
        int numTimes = 0;
        for (int i = 0; i < dice.size(); i++)
        {
            if (dice.get(i).getValue() == val)
                numTimes++;     
        }
        return numTimes;
    }
    /**
     * Method to return the Sum of Die values in the ArrayList
     * @return sum of Die values
     */
    public int sum(){
        int sum = 0;
        for (int i = 0; i < dice.size(); i++)
        {
                sum += dice.get(i).getValue();    
        }
        return sum;
    }
    /**
     * Method to test if a value is in the ArrayList
     * @param val value to test for
     * @return true if in the ArrayList, false if not
     */
    public boolean contains(int val){
        boolean status = false;
        for (int i = 0; i < dice.size(); i++)
        {
            if (dice.get(i).getValue() == val)
                status = true;
        }
        return status;
    }
    /**
     * Method that returns a formatted string representation of the ArrayList
     * @return a string of each value of the Die
     */
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < dice.size(); i++)
        {
            s += String.format("%d:   value %d\n", i + 1, dice.get(i).getValue());
        }
        return s;
    }

    public static void main(String[] args){
        
        Die d = new Die();
        Die a = new Die();

        Dice da = new Dice();
        da.addDie(d);
        da.addDie(a);

        System.out.print(da);

    }
    
}
