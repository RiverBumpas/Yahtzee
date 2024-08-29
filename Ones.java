//River Bumpas
//CS110 OL
//Final Project
public class Ones extends Category{
     /**
     * Method to evaluate the Die in the Dice object for Ones
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        return d.count(1);
    }
}
