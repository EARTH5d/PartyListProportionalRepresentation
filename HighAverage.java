
/**
 * Write a description of class Method here.
 *
 * @author Casey Alton Marshall
 * @version 5/24/2026
 */

import java.util.*;
//import java.io.*;
//import java.lang.Math;

public abstract class HighAverage extends Method {
	/**
	 * Constructor for objects of class Method
	 */
	public HighAverage() {
		// initialise instance variables
		super();

	}

	/**
	 * Alternate Constructor for objects of class Method with a parameter to pass in
	 * the number of seats.
	 */
	public HighAverage(int openSeats) {
		// initialise instance variables
		super();
		seats = openSeats;

	}

	/**
	 * Alternate Constructor for objects of class Method with a parameter to pass in
	 * the text file name.
	 */
	public HighAverage(String fileName) {
		// initialise instance variables
		super();
		file = fileName;

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats and the text file name.
	 */
	public HighAverage(int openSeats, String fileName) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = fileName;

	}

	public HighAverage(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super();
		seats = openSeats;
		file = "N/A";
		this.parties = parties;
	}

	/**
	 * Assigned each party seats base on how many votes the got.
	 */
	public void allocateSeats() {
		Party curr = new Party();

		int index = 0;
		int assignedSeats = 0;
		double currQuot = 0;
		double maxQuot = 0;
		int winner = 0;

		List<Integer> tiedWinners = new ArrayList<Integer>();

		while (assignedSeats < seats) {
			index = 0;
			maxQuot = 0;

			for (ListIterator<Party> it = parties.listIterator(); it.hasNext();) {
				curr = it.next();
				currQuot = quotient(curr.getVotes(), curr.getSeats());
				// System.out.println(curr.getName() + "; votes: " + curr.getVotes() + "; seats:
				// " + curr.getSeats() + "; quot: " + currQuot);
				if (currQuot > maxQuot) {
					maxQuot = currQuot;
					winner = index;
					tiedWinners.clear();
					tiedWinners.add(index);
				} else if (currQuot == maxQuot) {
					tiedWinners.add(index);
				}
				index++;
			}

			if (tiedWinners.size() > 1) {
				winner = tiedWinners.get(new Random().nextInt(tiedWinners.size()));
			}

			curr = parties.get(winner);
			curr.setSeats(curr.getSeats() + 1);
			parties.set(winner, curr);
			// System.out.println(curr.getName() + " has won a seat. They now have " +
			// curr.getSeats() + " seat(s).");
			assignedSeats++;
		}
	}

	/**
	 * Caluated the quotient of a party.
	 * 
	 * @param int votes, int currSeats.
	 * @return the Parties current quotient (quot) as a double.
	 */
	protected abstract double quotient(int votes, int currSeats);
}
