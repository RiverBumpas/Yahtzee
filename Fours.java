//River Bumpas
//CS110 OL
//Final Project
public class Fours extends Category{
    /**
     * Method to evaluate the Die in the Dice object for Fours
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        return 4 * d.count(4); //Returning the number of fours times the value(four)
    }
}
