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
		super();
		seats = openSeats;
	}

	/**
	 * Alternate Constructor for objects of class Huntington-Hill with a parameter
	 * to pass in
	 * the text file name.
	 */
	public HuntingtonHillHA(String fileName) {
		// initialise instance variables
		super();
		file = fileName;
	}

	/**
	 * Alternate Constructor for objects of class Huntington-Hill with parameters to
	 * pass in
	 * the number of seats and the text file name.
	 */
	public HuntingtonHillHA(int openSeats, String fileName) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = fileName;
	}

	public HuntingtonHillHA(int openSeats, ArrayList<Party> parties) {
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
	 * @return the Parties current quotient.
	 */
	protected double quotient(int votes, int currSeats) {
		return (currSeats > 0) ? votes / Math.sqrt((double) currSeats * (currSeats + 1)) : Double.POSITIVE_INFINITY;
	}
}
