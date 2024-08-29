//River Bumpas
//CS110 OL
//Final Project
public abstract class Category {
    
    //Instance Variables
    private int score = 0;
    private boolean used;

    /**
     * Abstract method that will evaluate the Die in the Dice object and return a score
     * @param d Dice to evaluate
     * @return a score 
     */
    public abstract int evaluate(Dice d);
    /**
     * Method to add the value that the Dice produce to the score, and to mark the category as used
     * @param d Dice to evaluate
     */
    public void addValue(Dice d){
        score = evaluate(d);
        used = true;
    }
    /**
     * Method to return the current category score
     * @return the category score
     */
    public int getScore(){
        return score;
    }
    /**
     * Method to return if the category was used
     * @return if the category was used
     */
    public boolean getUsed(){
        return used;
    }


}
