import java.util.*;

/**
 * Write a description of class DHondt here.
 *
 * @author Casey Marshall
 * @version 7/19/2022
 */
public class DHondtHA extends HighAverage {

	/**
	 * Constructor for objects of class DHondt
	 */
	public DHondtHA() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class Droop with a parameter to pass in
	 * the number of seats.
	 */
	public DHondtHA(int openSeats) {
		// initialise instance variables
		super();
		seats = openSeats;
	}

	/**
	 * Alternate Constructor for objects of class Droop with a parameter to pass in
	 * the text file name.
	 */
	public DHondtHA(String fileName) {
		// initialise instance variables
		super();
		file = fileName;
	}

	/**
	 * Alternate Constructor for objects of class Droop with parameters to pass in
	 * the number of seats and the text file name.
	 */
	public DHondtHA(int openSeats, String fileName) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = fileName;
	}

	public DHondtHA(int openSeats, ArrayList<Party> parties) {
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
		return votes / (double) (currSeats + 1);
	}
}
