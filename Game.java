//River Bumpas
//CS110 OL
//Final Project
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Game {
    
    final static private int ROUNDS = 13;

    //Creating players
    Player p1 = new Player("Player 1");
    Player p2 = new Player("Player 2");

    //Creating scanner
    public static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Method to print the header at the start of the game
     * @return the header
     */
    public String welcome(){
        return String.format("%s\n%37s\n%s","*******************************************************", "WELCOME TO YAHTZEE", "*******************************************************\n" );  
    }
    /**
     * Method to print out the category scores
     * @param p player 
     * @return player category scores
     */
    public String catScore(Player p){
        String str = "";
        for(CategoryValue cv: CategoryValue.values()){
            str += String.format("%d: %s,  %d points\n", cv.getValue() + 1, cv, p.sCard.getCategoryScore(cv));
        }
        return str;
    }
    /**
     * Method to sort die into saveDice 
     * @param input user input of indices
     * @param playDice list of playDice
     * @param saveDice list of saveDice
     */
    public void diceRolling(String input, Dice playDice, Dice saveDice) throws NumberFormatException{
        //Creating an array of strings, each one an index
        String fInput = input.substring(1, input.length() - 1);
        String[] inputList = fInput.split(" ");
        int minIndex = 1;
        //Validating that the indices are in bounds
        for (int i = 0; i < inputList.length; i++)
        {
            if (Integer.parseInt(inputList[i]) < minIndex || Integer.parseInt(inputList[i]) > playDice.getNumDice()){
                throw new NumberFormatException();
            }
        }
        //Adding each index to an ArrayList, validating that there are no repeats, and sorting it
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < inputList.length; i++){
            int add = Integer.parseInt(inputList[i]);
            if (indexList.contains(add - 1)){
                throw new NumberFormatException();
            }
            else{
                indexList.add(add - 1);
            }
        }
        Collections.sort(indexList);
        //Adding and removing die from playDice and saveDice
        for(int i = indexList.size() - 1; i >= 0; i--)
        {
            int index = indexList.get(i);
            saveDice.addDie(playDice.getDie(index));
            playDice.removeDie(index);
        }
        
    }    
    /**
     * Method to print the reroll dice
     * @param playDice dice to reroll
     */
    public void printReroll(Dice playDice){
        String str = "";
        if (!(playDice.getNumDice() == 0))
            str += "Dice to reroll:\n";
            str += playDice;
            System.out.print(str);
    }
    /**
     * Method to print the saved dice
     * @param saveDice dice to save
     */
    public void printSave(Dice saveDice){
        String str = "";
        if (!(saveDice.getNumDice() == 0))
            str += "Dice to save:\n";
            str += saveDice;
            System.out.print(str);
    }
    /**
     * Method to operate the score function
     * @param p player
     */
    public void score(Player p, Dice playDice, Dice saveDice){
        //Loop to add remaining dice to saveDice
        for (int i = 0; i < playDice.getNumDice(); i++)
        {
            saveDice.addDie(playDice.getDie(i));
        }
        //Loop to remove remaining dice from playDice
        for (int i = 0; i < playDice.getNumDice(); i++)
        {
            playDice.removeDie(i);
        }
        boolean valid = false;
        while (valid != true){
            try{
                //Printing dice to choose from and current category scores
                System.out.println("Final Roll:");
                System.out.println(saveDice);
                System.out.println("Select a category that you have not scored in yet:");
                System.out.println(catScore(p));
                //Making a variable for each die
                int input = Integer.parseInt(scanner.nextLine());
                //Looping through each category value and scoring the one the user chooses
                for(CategoryValue cv : CategoryValue.values()){
                    if (input - 1 == cv.getValue() && p.sCard.checkScored(cv) == false){
                        p.sCard.choose(cv, saveDice);
                        System.out.println(String.format("You scored %d points in %s", p.sCard.getCategoryScore(cv), cv));
                        System.out.println("\n\n******************************************************");
                        valid = true;
                    }
                    //Message for user if they have a yahtzee bonus
                    else if(input - 1 == 11 && p.sCard.getEvaluation(cv, saveDice) == 50 && p.sCard.checkScored(cv)){
                        System.out.println("Yahtzee bonus! You scored 100 points");
                        valid = true;
                    }
                }
            }
            catch(Exception e){
                System.out.println("Invalid input. Enter an unused integer category value");
            }
        } 
    }
    /**
     * Method to play a full turn for a player
     * @param p player
     */
    public void turn(Player p){
            //Creating variables needed to play a turn
            DiceRoll playDice = new DiceRoll();
            Dice saveDice = new Dice();
            //Printing out the users name and scorecard
            System.out.println(p);
            System.out.println(p.sCard);
            
            //Loop to handle the possibile actions in a turn
            int move = 0;
            boolean scored = false;
            while (move < 3){
                try{
                    printReroll(playDice);
                    printSave(saveDice);
                    System.out.println("Save dice with [ ] filled with index values seperated by spaces \n'roll' to reroll, 'score' to score");
                    String next = scanner.nextLine();
                    //Handling roll action
                    if (next.equals("roll")){ 
                        System.out.println(p.sCard);
                        playDice.toss();
                        move++;
                    }
                    //Handling score action
                    else if (next.equals("score")){
                        score(p, playDice, saveDice);
                        move = 3;
                        scored = true;
                    }
                    //Handling saving dice action
                    else if(next.startsWith("[") && next.endsWith("]")){
                        diceRolling(next, playDice, saveDice);
                        move++;
                    }
                    //Handling if no proper action is taken
                    else{
                        System.out.println("Please enter a valid die number, roll, or score");
                    }
                }
                catch(NumberFormatException n ){
                    System.out.println("Please enter a valid index");
                }
            }
        if (scored == false)
            score(p, playDice, saveDice);
        }
    /**
     * Method to play the game
     */
    public void playGame(){
        System.out.print(welcome());
        for(int i = 0; i < ROUNDS; i++){
            turn(p1);
            turn(p2);
        }
    }
}
