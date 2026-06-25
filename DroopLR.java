import java.util.*;

/**
 * Description:
 *
 * @author Casey Alton Marshall
 * @version 5/25/2026
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
		super(openSeats);
	}

	/**
	 * Alternate Constructor for objects of class DroopLR with a parameter to pass
	 * in the text file name.
	 */
	public DroopLR(String fileName) {
		// initialise instance variables
		super(fileName);
	}

	/**
	 * Alternate Constructor for objects of class DroopLR with parameters to pass in
	 * the number of seats and the text file name.
	 */
	public DroopLR(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);
	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public DroopLR(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
	}

	public DroopLR(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public DroopLR(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);

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
