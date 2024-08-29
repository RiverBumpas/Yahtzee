//River Bumpas
//CS110 OL
//Final Project
public class Twos extends Category{
    /**
     * Method to evaluate the Die in the Dice object for Twos
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        return 2 * d.count(2); //Returning the number of twos by the value (two)
    }
}
