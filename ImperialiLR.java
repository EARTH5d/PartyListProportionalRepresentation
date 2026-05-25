import java.util.*;

/**
 * Write a description of class ImperialiLR here.
 *
 * @author Casey Alton Marshall
 * @version 5/25/2026
 */
public class ImperialiLR extends LargestRemainder {
	/**
	 * Constructor for objects of class ImperialiLR
	 */
	public ImperialiLR() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class ImperialiLR with a parameter to
	 * pass
	 * in the number of seats.
	 */
	public ImperialiLR(int openSeats) {
		// initialise instance variables
		super(openSeats);
	}

	/**
	 * Alternate Constructor for objects of class ImperialiLR with a parameter to
	 * pass
	 * in the text file name.
	 */
	public ImperialiLR(String fileName) {
		// initialise instance variables
		super(fileName);
	}

	/**
	 * Alternate Constructor for objects of class ImperialiLR with parameters to
	 * pass in
	 * the number of seats and the text file name.
	 */
	public ImperialiLR(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);
	}

	/**
	 * Alternate Constructor for objects of class ImperialiLR with parameters to
	 * pass in the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public ImperialiLR(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
	}

	public ImperialiLR(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public ImperialiLR(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);

	}

	/**
	 * Caluated the quotient of a party.
	 * 
	 * @param int votes.
	 * @return the Parties current (Imperiali) quotient in the form of a double.
	 */
	protected double quotient(int votes) {
		return votes / (double) (seats + 2);
	}
}
