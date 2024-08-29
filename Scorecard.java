//River Bumpas
//CS110 OL
//Final Project
import java.util.ArrayList;
public class Scorecard{

    //Instance Variables
    private ArrayList<Category> scorecard = new ArrayList<>();
    private int yahtzeeBonus = 0;
    private final int NUM_CATS = 13;

    /**
     * Constructor method that creates and adds all Categories to the ArrayList
     */
    public Scorecard(){
        scorecard.add(new Ones());
        scorecard.add(new Twos());
        scorecard.add(new Threes());
        scorecard.add(new Fours());
        scorecard.add(new Fives());
        scorecard.add(new Sixes());
        scorecard.add(new ThreeOfAKind());
        scorecard.add(new FourOfAKind());
        scorecard.add(new FullHouse());
        scorecard.add(new SmStraight());
        scorecard.add(new LgStraight());
        scorecard.add(new FiveOfAKind());
        scorecard.add(new Chance());
    }
    /**
     * Method to score the appropriate Category and indicate that it has been scored
     * @param cv CategoryValue to check
     * @param d Dice to evaluate
     */
    public void choose(CategoryValue cv, Dice d){
        scorecard.get(cv.getValue()).addValue(d);
        //Testing for yahtzee bonus
        if(scorecard.get(11).getUsed() && getEvaluation(cv, d) == 50 && cv.getValue() == 11){
            yahtzeeBonus += 100;
        }
    }
    /**
     * Method that returns the score achieved in the Category with the given Dice
     * @param cv CategoryValue to check
     * @param d Dice to evaluate
     * @return the score earned
     */
    public int getEvaluation(CategoryValue cv, Dice d){
        return scorecard.get(cv.getValue()).evaluate(d);
    }
    /**
     * Method that checks if a Category has been used
     * @param cv CategoryValue to check
     * @return true if Category has been used, false if not 
     */
    public boolean checkScored(CategoryValue cv){
        return scorecard.get(cv.getValue()).getUsed();
    }
    /**
     * Method to return the current score for the specified category
     * @param cv CategoryValue to check
     * @return the current score for the specified category
     */
    public int getCategoryScore(CategoryValue cv){
        return scorecard.get(cv.getValue()).getScore();
    }
    /**
     * Method to return the total score for the top of the scorecard
     * @return score of the top of the scorecard
     */
    public int scoreTop(){
        int sum = 0;
        final int MAX_TOP_INDEX = 5;
        for (int i = 0; i <= MAX_TOP_INDEX; i++ )
            sum += scorecard.get(i).getScore();
        return sum;
    }
    /**
     * Method to return the total score of the bottom of the scorecard
     * @return score of the bottom of the scorecard
     */
    public int scoreBottom(){
        int sum = 0;
        for (int i = 6; i < NUM_CATS; i++)
            sum += scorecard.get(i).getScore();
        return sum + yahtzeeBonus;
    }
    /**
     * Method to return the total score of the scorecard
     * @return score of the scorecard
     */
    public int score(){
        return scoreBottom() + scoreTop();
    }
    /**
     * Method to return a formatted string of the information in the class
     * @return a formatted string
     */
    @Override
    public String toString(){
        String str = "";
        str += String.format("Current Scorecard:\n");
        for (CategoryValue cv: CategoryValue.values()){
            str += String.format("%15s: %d\n", cv, getCategoryScore(cv));
        }
        str += String.format("%15s: %d\n", "Upper Total", scoreTop());
        str += String.format("%15s: %d\n", "Lower Total", scoreBottom());
        str += String.format("%15s: %d", "Total", score());

        return str;
    }
}