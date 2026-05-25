import java.util.*;

/**
 * Write a description of class DroopLR here.
 *
 * @author Casey Alton Marshall
 * @version 5/24/2026
 */
public class DroopLR extends LargestRemainder {
	/**
	 * Constructor for objects of class DroopLR
	 */
	public DroopLR() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class DroopLR with a parameter to pass
	 * in the number of seats.
	 */
	public DroopLR(int openSeats) {
		// initialise instance variables
		super();
		seats = openSeats;
	}

	/**
	 * Alternate Constructor for objects of class DroopLR with a parameter to pass
	 * in the text file name.
	 */
	public DroopLR(String fileName) {
		// initialise instance variables
		super();
		file = fileName;
	}

	/**
	 * Alternate Constructor for objects of class DroopLR with parameters to pass in
	 * the number of seats and the text file name.
	 */
	public DroopLR(int openSeats, String fileName) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = fileName;
	}

	public DroopLR(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = "N/A";
		this.parties = parties;
	}

	/**
	 * Caluated the quotient of a party.
	 * 
	 * @param int votes.
	 * @return the Parties current (Droop) quotient in the form of a double.
	 */
	protected double quotient(int votes) {
		return Math.floor(votes / (double) (seats + 1)) + 1;
	}
}
