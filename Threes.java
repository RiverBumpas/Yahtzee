//River Bumpas
//CS110 OL
//Final Project
public class Threes extends Category{
    /**
     * Method to evaluate the Die in the Dice object for Threes
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        return 3 * d.count(3); //Returning the number of threes times the value(three)
    }
}
