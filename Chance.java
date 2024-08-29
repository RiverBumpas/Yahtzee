//River Bumpas
//CS110 OL
//Final Project
public class Chance extends Category{
     /**
     * Method to evaluate the Die in the Dice object for a Chance
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        return d.sum();
    }
}
