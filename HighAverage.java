
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
		super(openSeats);

	}

	/**
	 * Alternate Constructor for objects of class Method with a parameter to pass in
	 * the text file name.
	 */
	public HighAverage(String fileName) {
		// initialise instance variables
		super(fileName);

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats and the text file name.
	 */
	public HighAverage(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public HighAverage(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
	}

	public HighAverage(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public HighAverage(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);

	}

	/**
	 * Assigned each party seats base on how many votes the got.
	 */
	public void allocateSeats() {
		Party curr = null;

		int index = 0;
		int assignedSeats = 0;
		double currQuot = 0;
		double maxQuot = 0;
		int winner = 0;

		List<Integer> tiedWinners = new ArrayList<Integer>();
		List<Party> parties = (threshold <= 0.0) ? this.parties : filterList();

		while (assignedSeats < seats) {
			index = 0;
			maxQuot = 0;

			for (ListIterator<Party> it = parties.listIterator(); it.hasNext();) {
				curr = it.next();
				currQuot = quotient(curr.getVotes(), curr.getSeats());
				// System.out.println(curr.getName() + "; votes: " + curr.getVotes() + ";
				// seats:" + curr.getSeats()
				// + "; quot: " + currQuot);
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

	/*
	 * A protected function to create a array list of that contains all parties that
	 * meeted the threshold.
	 * 
	 * @param none
	 * 
	 * @return A array list of parties that meant the threshold.
	 */
	/*
	 * protected List<Party> filterList() {
	 * Party curr = null;
	 * List<Party> filteredList = new ArrayList<Party>();
	 * for (int i = 0; i < total; i++) {
	 * curr = this.parties.get(i);
	 * if (findPercentage(i) >= threshold) {
	 * filteredList.add(curr);
	 * }
	 * 
	 * }
	 * return filteredList;
	 * 
	 * }
	 */

	/**
	 * Caluated the quotient of a party.
	 * 
	 * @param int votes, int currSeats.
	 * @return the Parties current quotient (quot) as a double.
	 */
	protected abstract double quotient(int votes, int currSeats);
}
