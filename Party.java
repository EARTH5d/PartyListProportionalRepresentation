
/**
 * Class Party - A class that represents a political party competing in an
 * election using party list PR.
 * Through in an honestly I am more of a Single Tranferable Voting or
 * Proportional Approval Voting kind of guy. I just do not want to create all
 * the ballots.
 * Plus I also wasn't aware that Proportional forms of approval voting existence
 * when I first start to make this.
 *
 * @author Casey Marshall
 * @version 10/5/2025
 */
public class Party {
    private String name;
    private int votes;
    private int seats;

    /**
     * Deflaut Constructor for objects of class Party
     */
    public Party() {
        // initialise instance variables
        name = "N/A";
        votes = 0;
        seats = 0;
    }

    /**
     * Alternate constructor for objects of class Party
     * Takes in parameters for the name of the Party and it's number of votes.
     * 
     * @param String newName, int voters
     */
    public Party(String newName, int voters) {
        // initialise instance variables
        name = newName;
        votes = voters;
        seats = 0;
    }

    /**
     * Set the name of a Party.
     * 
     * @param String newName.
     * @return None.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Set the number of vote the party got.
     * 
     * @param int amount.
     * @return None.
     */
    public void setVotes(int amount) {
        votes = amount;
    }

    /**
     * Set the number of seat assigned to the Party.
     * 
     * @param int amount.
     * @return None.
     */
    public void setSeats(int amount) {
        seats = amount;
    }

    /**
     * Returns the name the party.
     * 
     * @param None.
     * @return The name of the party.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of votes the party got.
     * 
     * @param None.
     * @return The number of votes the party has.
     */
    public int getVotes() {
        return votes;
    }

    /**
     * Returns the number of seat that the Party has been assigned.
     * 
     * @param None.
     * @return Number of seat the party (currently) has.
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Display all data store in an instance of the class Party.
     * 
     * @param None
     * @return void, prints out the varibles of an instance of the Party class.
     */
    public void display() {
        System.out.println(name + " | seats won: " + seats + " | Votes " + votes);
    }

    /**
     * Returns a String represenation of a Party object.
     * 
     * @param None.
     * @return a string representing an instance of the class Party.
     */
    public String toString() {
        return name + ' ' + votes + ' ' + seats;
    }
}
