
/**
 * Abstract class LargestRemainder - write a description of the class here
 *
 * @author Casey Alton Marshall
 * @version 5/24/2026
 */

import java.util.*;
//import java.io.*;
import java.lang.Math;

public abstract class LargestRemainder extends Method {
	public LargestRemainder() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class LargestRemainder with a parameter
	 * to pass in the number of seats.
	 */
	public LargestRemainder(int openSeats) {
		// initialise instance variables
		super(openSeats);

	}

	/**
	 * Alternate Constructor for objects of class LargestRemainder with a parameter
	 * to pass in the text file name.
	 */
	public LargestRemainder(String fileName) {
		// initialise instance variables
		super(fileName);

	}

	/**
	 * Alternate Constructor for objects of class LargestRemainder with parameters
	 * to pass in the number of seats and the text file name.
	 */
	public LargestRemainder(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public LargestRemainder(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
	}

	public LargestRemainder(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public LargestRemainder(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);

	}

	/**
	 * Assigned each party seats base on how many votes the got.
	 */
	public void allocateSeats() {
		int index = 0;
		int assignedSeats = 0;
		// int currVotes = 0;
		int currSeats = 0;
		int winner = -1;

		double Quote = 0;
		double currEntitlement = 0;
		double currRemainder = 0;
		double LargestRemainder = 0;

		Party curr = null;

		List<Double> remainders = new ArrayList<Double>();
		List<Integer> tiedWinners = new ArrayList<Integer>();
		List<Party> parties = (threshold <= 0.0) ? this.parties : filterList();
		int totalVotes = findTotalTally(parties);

		for (Party it : parties) {
			it.setSeats(0);
		}
		Quote = quotient(totalVotes);

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

		while (assignedSeats < seats) {
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
	}

	// protected List<Party> filterList() {
	// return parties;
	// }

	/**
	 * Caluated the quotient of a party.
	 * 
	 * @param int votes, int currSeats.
	 * @return the Parties current quotient in the form of an double.
	 */
	protected abstract double quotient(int votes);
}
