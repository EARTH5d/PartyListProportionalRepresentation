import java.util.*;

/**
 * Write a description of class Droop here.
 *
 * @author Casey Marshall
 * @version 5/24/2026
 */

public class HuntingtonHillHA extends HighAverage {

	/**
	 * Constructor for objects of class Huntington-Hill
	 */
	public HuntingtonHillHA() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class Huntington-Hill with a parameter
	 * to pass in
	 * the number of seats.
	 */
	public HuntingtonHillHA(int openSeats) {
		// initialise instance variables
		super(openSeats);
	}

	/**
	 * Alternate Constructor for objects of class Huntington-Hill with a parameter
	 * to pass in
	 * the text file name.
	 */
	public HuntingtonHillHA(String fileName) {
		// initialise instance variables
		super(fileName);
	}

	/**
	 * Alternate Constructor for objects of class Huntington-Hill with parameters to
	 * pass in
	 * the number of seats and the text file name.
	 */
	public HuntingtonHillHA(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);
	}

	/**
	 * Alternate Constructor for objects of class HuntingtonHillHA with parameters
	 * to pass
	 * in the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public HuntingtonHillHA(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
	}

	public HuntingtonHillHA(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public HuntingtonHillHA(int openSeats, double threshold, ArrayList<Party> parties) {
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
	 * @return the Parties current quotient.
	 */
	protected double quotient(int votes, int currSeats) {
		return (currSeats > 0) ? (votes / Math.sqrt((double) currSeats * (currSeats + 1))) : Double.POSITIVE_INFINITY;
	}
}
