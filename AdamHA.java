import java.util.*;

/**
 * Write a description of class Droop here.
 *
 * @author Casey Marshall
 * @version 5/23/2026
 */

public class AdamHA extends HighAverage {

    /**
     * Constructor for objects of class Adam
     */
    public AdamHA() {
        super();
    }

    /**
     * Alternate Constructor for objects of class Adam with a parameter to pass in
     * the number of seats.
     */
    public AdamHA(int openSeats) {
        // initialise instance variables
        super();
        seats = openSeats;
    }

    /**
     * Alternate Constructor for objects of class Adam with a parameter to pass in
     * the text file name.
     */
    public AdamHA(String fileName) {
        // initialise instance variables
        super();
        file = fileName;
    }

    /**
     * Alternate Constructor for objects of class Adam with parameters to pass in
     * the number of seats and the text file name.
     */
    public AdamHA(int openSeats, String fileName) {
        // initialise instance variables
        super();
        seats = openSeats;
        file = fileName;
    }

    public AdamHA(int openSeats, ArrayList<Party> parties) {
        // initialise instance variables
        super();
        seats = openSeats;
        file = "N/A";
        this.parties = parties;
    }

    public void allocateSeats() {
        for (Party p : parties) {
            p.setSeats(0);
        }
        super.allocateSeats();
    }

    /**
     * Caluated the quotient of a party.
     * 
     * @param int votes, int currSeats.
     * @return the Parties current quotient (quot).
     */
    protected double quotient(int votes, int currSeats) {
        return (currSeats > 0) ? votes / (double) currSeats : Double.POSITIVE_INFINITY;
    }
}
