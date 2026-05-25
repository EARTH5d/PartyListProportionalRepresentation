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
        super(openSeats);
    }

    /**
     * Alternate Constructor for objects of class Adam with a parameter to pass in
     * the text file name.
     */
    public AdamHA(String fileName) {
        // initialise instance variables
        super(fileName);
    }

    /**
     * Alternate Constructor for objects of class Adam with parameters to pass in
     * the number of seats and the text file name.
     */
    public AdamHA(int openSeats, String fileName) {
        // initialise instance variables
        super(openSeats, fileName);
    }

    /**
     * Alternate Constructor for objects of class Method with parameters to pass in
     * the number of seats, a threshold and a pre-created list of parties.
     * 
     * @param int openSeats, double threshold, String fileName
     */
    public AdamHA(int openSeats, double threshold, String fileName) {
        super(openSeats, threshold, fileName);
    }

    public AdamHA(int openSeats, ArrayList<Party> parties) {
        // initialise instance variables
        super(openSeats, parties);
    }

    public AdamHA(int openSeats, double threshold, ArrayList<Party> parties) {
        // initialise instance variables
        super(openSeats, threshold, parties);

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
        return (currSeats > 0) ? votes / (double) currSeats
                : ((currSeats == 0) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
    }
}
