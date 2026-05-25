import java.util.*;

/**
 * Write a description of class DroopLR here.
 *
 * @author Casey Alton Marshall
 * @version 5/24/2026
 */
public class DroopLR_Sq extends Method {
	/**
	 * Constructor for objects of class DroopLR_Sq
	 */
	public DroopLR_Sq() {
		super();
	}

	/**
	 * Alternate Constructor for objects of class DroopLR_Sq with a parameter to
	 * pass
	 * in the number of seats.
	 */
	public DroopLR_Sq(int openSeats) {
		// initialise instance variables
		super(openSeats);
	}

	/**
	 * Alternate Constructor for objects of class DroopLR_Sq with a parameter to
	 * pass
	 * in the text file name.
	 */
	public DroopLR_Sq(String fileName) {
		// initialise instance variables
		super(fileName);
	}

	/**
	 * Alternate Constructor for objects of class DroopLR_Sq with parameters to pass
	 * in
	 * the number of seats and the text file name.
	 */
	public DroopLR_Sq(int openSeats, String fileName) {
		// initialise instance variables
		super(openSeats, fileName);
	}

	/**
	 * Alternate Constructor for objects of class Method with parameters to pass in
	 * the number of seats, a threshold and a pre-created list of parties.
	 * 
	 * @param int openSeats, double threshold, String fileName
	 */
	public DroopLR_Sq(int openSeats, double threshold, String fileName) {
		super(openSeats, threshold, fileName);
	}

	public DroopLR_Sq(int openSeats, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, parties);
	}

	public DroopLR_Sq(int openSeats, double threshold, ArrayList<Party> parties) {
		// initialise instance variables
		super(openSeats, threshold, parties);

	}

	// protected List<Party> filterList() {
	// return parties;
	// }

	public void allocateSeats() {
		int totalSeatsAllocated = 0;
		int seatsAllocatedThisRound = 0;
		int currSeats = 0;

		Party curr;
		ArrayList<Party> partiesTemp = new ArrayList<Party>();

		DroopLR recursitiveAllocation;

		for (Party currParty : parties) {
			partiesTemp.add(new Party(currParty.getName(), currParty.getVotes()));
			currParty.setSeats(0);
		}

		do {
			int emptySeats = this.seats - totalSeatsAllocated;
			for (Party currParty : partiesTemp) {
				currParty.setSeats(0);
			}
			recursitiveAllocation = new DroopLR(emptySeats, this.threshold, partiesTemp);
			recursitiveAllocation.allocateSeats();
			for (int i = 0; i < parties.size(); i++) {
				curr = parties.get(i);
				currSeats = partiesTemp.get(i).getSeats();
				seatsAllocatedThisRound += currSeats;
				curr.setSeats(curr.getSeats() + currSeats);

			}
			if (seatsAllocatedThisRound == 0) {
				break;
			}
			totalSeatsAllocated += seatsAllocatedThisRound;
			seatsAllocatedThisRound = 0;
		} while (totalSeatsAllocated < this.seats);
	}

}
