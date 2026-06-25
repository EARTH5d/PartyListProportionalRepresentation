
/**
 * Abstract class Method - An abstract class for the varius methods used to allocated seats.
 *
 * @author Casey Alton Marshall
 * @version 5/25/2026
 */

import java.util.*;
import java.io.*;
//import java.lang.Math;

public abstract class Method {

	protected int total; // Total number of parties that competed in this election.
	protected int seats; // Number of seats up for election.
	protected int totalVotes; // The total number of votes.
	protected double threshold; // A percentage of votes a party must pass in order to be able to receive seats.
	protected List<Party> parties; // The arrayList which instances of the class Party are stored.
	protected String file; // The name of the text file which contains the tally of votes.

	/**
	 * Defluat constructor for objects of class Method
	 */
	public Method() {
		// initialise instance variables
		total = 0;
		Random rand = new Random();
		seats = rand.nextInt(2996) + 5;
		threshold = 0.0;
		file = "Fictional-1.txt";
		parties = new ArrayList<Party>();
		totalVotes = 0;

	}

	/**
	 * Alternate Constructor for objects of class Method with a parameter to pass in
	 * the number of seats.
	 * 
	 * @param int openSeats
	 */
	public Method(int openSeats) {
		// initialise instance variables
		total = 0;
		seats = openSeats;
		threshold = 0.0;
		file = "Fictional-1.txt";
		parties = new ArrayList<Party>();
		totalVotes = 0;

	}

	/**
	 * Alternate Constructor for objects of class Method with a parameter to pass in
	 * the text file name.
	 * 
	 * @param String fileName
	 */
	public Method(String fileName) {
		// initialise instance variables
		total = 0;
		Random rand = new Random();
		seats = rand.nextInt(2996) + 5;
		threshold = 0.0;
		file = fileName;
		parties = new ArrayList<Party>();
		totalVotes = 0;

	}

	/**
	 * Alternate Constructor for objects of class Method with a parameter of a
	 * pre-created list of parties.
	 * 
	 * @param ArrayList<Party> parties
	 */
	public Method(ArrayList<Party> parties) {
		// initialise instance variables
		total = parties.size();
		Random rand = new Random();
		seats = rand.nextInt(2996) + 5;
		threshold = 0.0;
		file = "N/A";
		this.parties = parties;
		findTotalTally();

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats and a pre-created list of parties.
	 * 
	 * @param int openSeats, String fileName
	 */
	public Method(int openSeats, String fileName) {
		// initialise instance variables
		total = 0;
		seats = openSeats;
		threshold = 0.0;
		file = fileName;
		parties = new ArrayList<Party>();
		totalVotes = 0;

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public Method(int openSeats, double threshold, String fileName) {
		// initialise instance variables
		total = 0;
		seats = openSeats;
		this.threshold = threshold;
		file = fileName;
		parties = new ArrayList<Party>();

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats and an ArrayList of parties.
	 * 
	 * @param int openSeats, ArrayList<Party> parties
	 */
	public Method(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		total = parties.size();
		seats = openSeats;
		threshold = 0.0;
		file = "N/A";
		this.parties = parties;
		findTotalTally();
	}

	public Method(int openSeats, List<Party> parties) {
		// initialise instance variables
		total = parties.size();
		seats = openSeats;
		threshold = 0.0;
		file = "N/A";
		this.parties = parties;
		findTotalTally();
	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats, a threshold and an ArrayList of parties.
	 * 
	 * @param int openSeats, double threshold, ArrayList<Party> parties
	 */
	public Method(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		total = parties.size();
		seats = openSeats;
		this.threshold = threshold;
		file = "N/A";
		this.parties = parties;
		findTotalTally();

	}

	/**
	 * Add a party to the List of parties.
	 * 
	 * @param String name and int currVotes.
	 * @return None.
	 */
	private void add(String name, int currVotes) {
		Party newParty = new Party(name, currVotes);
		parties.add(total, newParty);
		total++;
		totalVotes += newParty.getVotes();
	}

	/**
	 * A private function that find the total number of votes.
	 * 
	 * @param None
	 * @return None(void)
	 */
	private void findTotalTally() {
		for (Party curr : this.parties) {
			totalVotes += curr.getVotes();
		}
	}

	/**
	 * A Protectedfunction that find the total number of votes.
	 * 
	 * @param ArrayList<Party> parties a list of parties.
	 * @return None(void)
	 */
	protected int findTotalTally(List<Party> parties) {
		int totalVotes = 0;
		for (Party curr : parties) {
			totalVotes += curr.getVotes();
		}
		return totalVotes;
	}

	/**
	 * A protected function to find the percatage of the total votes a party.
	 * received.
	 * 
	 * @param int partyIndex.
	 * @return double representing a the party's percentage of the total amount of
	 *         votes.
	 */
	protected double findPercentage(int partyIndex) {
		return (parties.get(partyIndex).getVotes() / (double) totalVotes);
	}

	/**
	 * A protected function to create a array list of that contains all parties that
	 * meeted the threshold.
	 * 
	 * @param none
	 * @return A array list of parties that meant the threshold.
	 */
	protected List<Party> filterList() {
		Party curr = null;
		List<Party> filteredList = new ArrayList<Party>();
		for (int i = 0; i < total; i++) {
			curr = this.parties.get(i);
			if (findPercentage(i) >= threshold) {
				filteredList.add(curr);
			}

		}
		return filteredList;

	}

	/*
	 * A protected function to create a array list of that contains all parties that
	 * meeted the threshold.
	 */
	// protected abstract List<Party> filterList();

	/**
	 * A Public function to set/change the threshold.
	 * 
	 * @param double threshold.
	 * @return None.
	 */
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	/**
	 * Assigned seats to each party seats.
	 */
	public abstract void allocateSeats();

	/**
	 * Display election results.
	 * 
	 * @param none.
	 * @return none.
	 */
	public void results() {
		Party curr = new Party();
		System.out.println("The election results are: ");
		System.out.println("There were " + seats + " seats up in this election.");
		for (ListIterator<Party> it = parties.listIterator(); it.hasNext();) {
			curr = it.next();
			curr.display();
		}
	}

	/**
	 * Load the data from the file in to the list of parties.
	 */
	public void loadFile() throws IOException {

		if (file != "N/A") {

			FileReader inputFile = new FileReader(file);
			Scanner in = new Scanner(inputFile);
			Scanner tokenizer;
			String currLine;
			String name;
			int currNumber;

			while (in.hasNext()) {
				currLine = in.nextLine();
				tokenizer = new Scanner(currLine);
				String str = ":";
				tokenizer.useDelimiter(str);
				name = tokenizer.next();
				currNumber = tokenizer.nextInt();
				add(name, currNumber);
				tokenizer.close();
			}
			in.close();
		}
	}

}
