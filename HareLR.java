import java.util.*;

/**
 * Write a description of class HareLR here.
 *
 * @author Casey Alton Marshall
 * @version 6/20/2025
 */
public class HareLR extends LargestRemainder {
	/**
	 * Constructor for objects of class HareLR
	 */
	public HareLR() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class HareLR with a parameter to pass in
	 * the number of seats.
	 */
	public HareLR(int openSeats) {
		// initialise instance variables
		super();
		seats = openSeats;
	}

	/**
	 * Alternate Constructor for objects of class HareLR with a parameter to pass in
	 * the text file name.
	 */
	public HareLR(String fileName) {
		// initialise instance variables
		super();
		file = fileName;
	}

	/**
	 * Alternate Constructor for objects of class HareLR with parameters to pass in
	 * the number of seats and the text file name.
	 */
	public HareLR(int openSeats, String fileName) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = fileName;
	}

	public HareLR(int openSeats, ArrayList<Party> parties) {
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
	 * @return the Parties current (Hare) quotient in the form of a double.
	 */
	protected double quotient(int votes) {
		return votes / (double) seats;
	}
}
