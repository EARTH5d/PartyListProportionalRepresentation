import java.util.*;

/**
 * Write a description of class WebsterHA here.
 *
 * @author Casey Alotn Marshall
 * @version 10/5/2025
 */
public class WebsterHA extends HighAverage {
	// instance variables - replace the example below with your own

	/**
	 * Constructor for objects of class WebsterHA
	 */

	public WebsterHA() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class WebsterHA with a parameter to pass
	 * in the number of seats.
	 */
	public WebsterHA(int openSeats) {
		// initialise instance variables
		super();
		seats = openSeats;
	}

	/**
	 * Alternate Constructor for objects of class WebsterHA with a parameter to pass
	 * in the text file name.
	 */
	public WebsterHA(String fileName) {
		// initialise instance variables
		super();
		file = fileName;
	}

	/**
	 * Alternate Constructor for objects of class WebsterHA with parameters to pass
	 * in the number of seats and the text file name.
	 */
	public WebsterHA(int openSeats, String fileName) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = fileName;
	}

	public WebsterHA(int openSeats, ArrayList<Party> parties) {
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
		return votes / (double) (2 * currSeats + 1);
	}
}