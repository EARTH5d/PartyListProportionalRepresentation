
/**
 * @author Casey Alton Marshall
 * @version 5/25/2026
 */

import java.util.*;

public class SouthAfricanMethod extends Method {
	int cap;

	public SouthAfricanMethod() {
		super();
		cap = 5;
	}

	/**
	 * Alternate Constructor for objects of class SouthAfricanMethod with a
	 * parameter to pass in the number of seats.
	 */
	public SouthAfricanMethod(int openSeats) {
		// initialise instance variables
		super(openSeats);
		cap = 5;
	}

	/**
	 * Alternate Constructor for objects of class SouthAfricanMethod with a
	 * parameter to pass in the number of seats and the cap.
	 */
	public SouthAfricanMethod(int openSeats, int cap) {
		// initialise instance variables
		super(openSeats);
		this.cap = cap;
	}

	/**
	 * Alternate Constructor for objects of class SouthAfricanMethod with a
	 * parameter to pass in the text file name.
	 */
	public SouthAfricanMethod(String fileName) {
		// initialise instance variables
		super(fileName);
		cap = 5;
	}

	public SouthAfricanMethod(String fileName, int cap) {
		// initialise instance variables
		super(fileName);
		this.cap = cap;
	}

	/**
	 * Alternate Constructor for objects of class SouthAfricanMethod with parameters
	 * to pass in
	 * the number of seats and the text file name.
	 */
	public SouthAfricanMethod(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);
		cap = 5;
	}

	public SouthAfricanMethod(int openSeats, String fileName, int cap) {
		// initialise instance variables
		super(openSeats, fileName);
		this.cap = cap;
	}

	/**
	 * Alternate Constructor for objects of class SouthAfricanMethod with parameters
	 * to pass in
	 * the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public SouthAfricanMethod(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
		cap = 5;
	}

	public SouthAfricanMethod(int openSeats, double threshold, String fileName, int cap) {
		super(openSeats, threshold, fileName);
		this.cap = cap;
	}

	public SouthAfricanMethod(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
		cap = 5;
	}

	public SouthAfricanMethod(int openSeats, int cap, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
		this.cap = cap;
	}

	public SouthAfricanMethod(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);
		cap = 5;

	}

	public SouthAfricanMethod(int openSeats, double threshold, int cap, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);
		this.cap = cap;

	}

	public void allocateSeats() {
		int index = 0;
		int assignedSeats = 0;
		// int currVotes = 0;
		int currSeats = 0;
		int winner = -1;
		int remainder_index = 0;
		int emptySeats = 0;

		double Quote = 0;
		double currEntitlement = 0;
		double currRemainder = 0;
		double LargestRemainder = 0;

		Party curr = null;
		DHondtHA allocationOfRemainder = null;

		List<Double> remainders = new ArrayList<Double>();
		List<Integer> tiedWinners = new ArrayList<Integer>();
		for (Party it : this.parties) {
			it.setSeats(0);
		}
		List<Party> parties = (threshold <= 0.0) ? this.parties : filterList();
		int totalVotes = findTotalTally(parties);

		Quote = Math.floor(totalVotes / (double) (seats + 1)) + 1;

		for (ListIterator<Party> it = parties.listIterator(); it.hasNext();) {
			curr = it.next();
			currEntitlement = curr.getVotes() / Quote;
			currSeats = (int) Math.floor(currEntitlement);
			currRemainder = currEntitlement - currSeats;
			remainders.add(index, currRemainder);
			curr.setSeats(currSeats);
			// System.out.println(curr.getName() + "; Seats:" + currSeats + "; entitlement:"
			// + currEntitlement);
			assignedSeats += currSeats;
			index++;
		}

		while ((assignedSeats < seats) && (remainder_index < cap)) {
			index = 0;
			winner = -1;
			LargestRemainder = 0;
			currRemainder = -1;

			for (ListIterator<Double> it = remainders.listIterator(); it.hasNext();) {
				currRemainder = it.next();
				if (currRemainder > LargestRemainder) {
					LargestRemainder = currRemainder;
					winner = index;
					tiedWinners.clear();
					tiedWinners.add(index);
				} else if (currRemainder == LargestRemainder) {
					tiedWinners.add(index);
				}
				index++;
			}

			if (tiedWinners.size() > 1) {
				winner = tiedWinners.get(new Random().nextInt(tiedWinners.size()));
			}
			remainder_index++;

			if (winner != -1) {
				curr = parties.get(winner);
				curr.setSeats(curr.getSeats() + 1);
				parties.set(winner, curr);
				// System.out.println(curr.getName() + " has won a seat. They now have " +
				// curr.getSeats() + " seat(s).");
				remainders.set(winner, -1.0); // Removes this party's remainder.
				assignedSeats++;
			} else {
				break;
			}
		}

		parties = new ArrayList<Party>();

		if (assignedSeats < seats) {
			emptySeats = this.seats - assignedSeats;
			for (Party it : this.parties) {
				if (it.getSeats() > 0) {
					parties.add(it);
				}
			}
			allocationOfRemainder = new DHondtHA(emptySeats, parties);
			allocationOfRemainder.allocateSeats_Sq();
		}
	}

}