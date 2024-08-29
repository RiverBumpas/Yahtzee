//River Bumpas
//CS110 OL
//Final Project
public class Fives extends Category{
    /**
     * Method to evaluate the Die in the Dice object for Fives
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        return 5 * d.count(5); //Returning the number of fives times the value(five)
    }
}

