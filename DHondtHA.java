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
		super(openSeats);
	}

	/**
	 * Alternate Constructor for objects of class Droop with a parameter to pass in
	 * the text file name.
	 */
	public DHondtHA(String fileName) {
		// initialise instance variables
		super(fileName);
	}

	/**
	 * Alternate Constructor for objects of class Droop with parameters to pass in
	 * the number of seats and the text file name.
	 */
	public DHondtHA(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);
	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public DHondtHA(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
	}

	public DHondtHA(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public DHondtHA(int openSeats, List<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public DHondtHA(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);

	}

	public void allocateSeats() {
		for (Party p : parties) {
			p.setSeats(0);
		}
		super.allocateSeats();
	}

	public void allocateSeats_Sq() {
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
