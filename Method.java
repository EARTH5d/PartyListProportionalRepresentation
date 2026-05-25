
/**
 * Abstract class Method - An abstract class for the varius methods used to allocated seats.
 *
 * @author Casey Alton Marshall
 * @version 10/5/2025
 */

import java.util.*;
import java.io.*;
//import java.lang.Math;

public abstract class Method {

	protected int total; // Total number of parties that competed in this election.
	protected int seats; // Number of seats up for election.
	protected List<Party> parties; // The arrayList which instances of the class Party are stored.
	protected String file; // The name of the text file which contains the tally of votes.

	/**
	 * Defluat constructor for objects of class Method
	 */
	public Method() {
		// initialise instance variables
		total = 0;
		Random rand = new Random();
		seats = rand.nextInt(2995) + 5;
		file = "Fictional-1.txt";
		parties = new ArrayList<Party>();

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
		file = "Fictional-1.txt";
		parties = new ArrayList<Party>();

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
		seats = rand.nextInt(2995) + 5;
		file = fileName;
		parties = new ArrayList<Party>();

	}

	/**
	 * Alternate Constructor for objects of class Method with a parameter of a
	 * pre-created list of parties.
	 * 
	 * @param ArrayList<Party> parties
	 */
	public Method(ArrayList<Party> parties) {
		// initialise instance variables
		total = 0;
		Random rand = new Random();
		seats = rand.nextInt(2995) + 5;
		file = "N/A";
		this.parties = parties;

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
		file = fileName;
		parties = new ArrayList<Party>();

	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats and the text file name.
	 * 
	 * @param int openSeats, ArrayList<Party> parties
	 */
	public Method(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		total = 0;
		seats = openSeats;
		file = "N/A";
		this.parties = parties;

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
