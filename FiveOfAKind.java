//River Bumpas
//CS110 OL
//Final Project
public class FiveOfAKind extends Category{
    /**
     * Method to evaluate the Die in the Dice object for a Yahtzee(Five of a Kind)
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
            final int MAX_VALUE = 6; //Max value of a side of the die
            for (int i = 1; i <= MAX_VALUE ; i++ ){
                if (d.count(i) == 5){
                    return 50;
                }
            }
            return 0;       
    }
}