//River Bumpas
//CS110 OL
//Final Project
public class Player {
    
    //Instance variables
    private String name;
    Scorecard sCard = new Scorecard();

    /**
     * Constructor method to set name
     * @param name name to set
     */
    public Player(String name){
        this.name = name;
    }
    /**
     * Method to set the name of the player
     * @param name the name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Method to print the name of the player
     * @return the name of the player
     */
    @Override
    public String toString(){
        return name + ":";
    }
}
