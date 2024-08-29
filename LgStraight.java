//River Bumpas
//CS110 OL
//Final Project
public class LgStraight extends Category{
     /**
     * Method to evaluate the Die in the Dice object for a Large Straight
     * @param d Dice to evaluate
     * @return points earned from this category
     */
    public int evaluate(Dice d){
        //Checking for each possibility of 5 Die in a row
        if (d.contains(1) && d.contains(2) && d.contains(3) && d.contains(4) 
            && d.contains(5))
            return 40;
        else if (d.contains(2) && d.contains(3) && d.contains(4) && d.contains(5) 
                && d.contains(6))
            return 40;
        return 0;
    }
}
