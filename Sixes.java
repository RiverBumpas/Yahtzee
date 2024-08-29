//River Bumpas
//CS110 OL
//Final Project
public class Sixes extends Category{
    /**
     * Method to evaluate the Die in the Dice object for sixes
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        return 6 * d.count(6); //Returning the number of sixes times the value(six)
    }
}

