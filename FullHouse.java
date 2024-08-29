//River Bumpas
//CS110 OL
//Final Project
public class FullHouse extends Category{
    /**
     * Method to evaluate the Die in the Dice object for a Full House
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate (Dice d){
        int MAX_VALUE = 6; //Maximum value of the dice
        for (int i = 1; i <= MAX_VALUE; i++) //Loop to check for three of a kind
        {
            if (d.count(i) == 3)
            {
                for (int j = 1; j <= MAX_VALUE; j++) //Loop to check for pair, different value than before
                {
                    if(d.count(j) == 2 && i != j)
                        return 25;
                }
            }
            
        }
        return 0;
    }
}
