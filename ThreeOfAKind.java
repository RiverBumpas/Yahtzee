//River Bumpas
//CS110 OL
//Final Project
public class ThreeOfAKind extends Category{
    /**
     * Method to evaluate the Die in the Dice object for a Yahtzee(Five of a Kind)
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        final int MAX_VALUE = 6; //Maximum value of a side of a Die
        for (int i = 1; i <= MAX_VALUE ; i++ ){
            if (d.count(i) >= 3){
                return d.sum();
            }
        }
        return 0;       
    }
}