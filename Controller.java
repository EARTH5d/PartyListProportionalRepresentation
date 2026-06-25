import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Casey Alton Marshall
 * @version 6/22/2026
 */
public class Controller {
	// instance variables - replace the example below with your own
	private Scanner input;
	private Method currMethod;

	/**
	 * Constructor for objects of class Controller
	 * 
	 * @param Scanner input.
	 */
	public Controller(Scanner input) throws IOException {
		this.input = input;
		currMethod = null;
	}

	/**
	 * Display the menu.
	 */
	protected void displayMenu() {
		System.out.println("\n Chose a method");
		System.out.println(" 1.) DroopHA ");
		System.out.println(" 2.) DHondtHA");
		System.out.println(" 3.) WebsterHA ");
		System.out.println(" 4.) AdamHA ");
		System.out.println(" 5.) HuntingtonHillHA ");
		System.out.println(" 6.) DroopLR ");
		System.out.println(" 7.) HareLR ");
		System.out.println(" 8.) ImperialiLR ");
		System.out.println(
				" 9.) DroopLR_Sq If all leftover seats have not been allocated to a Party, then conduct another round of allocation with the original votes apply to the remainding seats");
		System.out.println(" 0.) SouthAfricanMethod ");
		System.out.println(" q.) to exit ");

	}

	/**
	 * A method the takes the users input and returns it frist character.
	 * 
	 * @return char.
	 */
	private char getSelection() {
		String in = input.nextLine();
		if (in.length() > 1) {
			return '日'; // Junk character, copied and pasted from a wikipedia artlice.
		} else {
			return in.charAt(0);
		}
	}

	/**
	 * Takes in the User's selection and does the chossen tasks.
	 * 
	 * @param char   selection
	 * @param int    seats
	 * @param double threshold
	 * @param String filename
	 */
	private void executeSelection(char selection, int seats, double threshold, String filename) {

		int cap = 0;
		boolean isEntered = false;

		switch (selection) {
			case '1':
				currMethod = new DroopHA(seats, threshold, filename);
				break;
			case '2':
				currMethod = new DHondtHA(seats, threshold, filename);
				break;
			case '3':
				currMethod = new WebsterHA(seats, threshold, filename);
				break;
			case '4':
				currMethod = new AdamHA(seats, threshold, filename);
				break;
			case '5':
				currMethod = new HuntingtonHillHA(seats, threshold, filename);
				break;
			case '6':
				currMethod = new DroopLR(seats, threshold, filename);
				break;
			case '7':
				currMethod = new HareLR(seats, threshold, filename);
				break;
			case '8':
				currMethod = new ImperialiLR(seats, threshold, filename);
				break;
			case '9':
				currMethod = new DroopLR_Sq(seats, threshold, filename);
				break;
			case '0':
				System.out.println("Please the cap. (The minimum is 0.) :");
				while (isEntered == false) {
					try {
						cap = input.nextInt();
						input.nextLine();
					} catch (InputMismatchException e) {
						System.err.println("Invalid input. Please enter an intger greater than 0.");
					}
					if (cap >= 0) {
						isEntered = true;
					}
				}
				currMethod = new SouthAfricanMethod(seats, threshold, filename, cap);
				break;
			default:
				System.out.println("Invaid Selection!");
				break;
		}

	}

	/**
	 * Takes in the User's selection and does the chossen tasks.
	 * 
	 * @param char             selection
	 * @param int              seats
	 * @param double           threshold
	 * @param ArrayList<Party> parties
	 */
	private void executeSelection(char selection, int seats, double threshold, ArrayList<Party> parties) {

		int cap = 0;
		boolean isEntered = false;

		switch (selection) {
			case '1':
				currMethod = new DroopHA(seats, threshold, parties);
				break;
			case '2':
				currMethod = new DHondtHA(seats, threshold, parties);
				break;
			case '3':
				currMethod = new WebsterHA(seats, threshold, parties);
				break;
			case '4':
				currMethod = new AdamHA(seats, threshold, parties);
				break;
			case '5':
				currMethod = new HuntingtonHillHA(seats, threshold, parties);
				break;
			case '6':
				currMethod = new DroopLR(seats, threshold, parties);
				break;
			case '7':
				currMethod = new HareLR(seats, threshold, parties);
				break;
			case '8':
				currMethod = new ImperialiLR(seats, threshold, parties);
				break;
			case '9':
				currMethod = new DroopLR_Sq(seats, threshold, parties);
				break;
			case '0':
				System.out.println("Please the cap. (The minimum is 0.) :");
				while (isEntered == false) {
					try {
						cap = input.nextInt();
						input.nextLine();
					} catch (InputMismatchException e) {
						System.err.println("Invalid input. Please enter an intger greater than 0.");
					}
					if (cap >= 0) {
						isEntered = true;
					}
				}
				currMethod = new SouthAfricanMethod(seats, threshold, cap, parties);
				break;
			default:
				System.out.println("Invaid Selection!");
				break;
		}

	}

	public void run() throws IOException {
		String filename = "test-1a.txt";

		char selection = ' ';
		int seats = 0;
		double threshold = 0.00;
		boolean isManual = true;
		boolean isEntered = false;

		ArrayList<Party> Parties = new ArrayList<Party>();

		System.out.println("Welcome to my Party List Proporitonal Representation Sim. \n");

		while (isEntered == false) {
			System.out.println(
					"Do you want to enter the results manualy (M or m) or load them from a .txt file (F or f)?");

			switch (getSelection()) {
				case 'F':
				case 'f':
					isManual = false;
				case 'M':
				case 'm':
					isEntered = true;
					break;
				default:
					System.out.println("Invaid Selection!");
					break;
			}
		}

		isEntered = false;
		while (isEntered == false) {
			System.out.println("Please the number of seat up this election. (The minimum is 1.) :");
			try {
				seats = input.nextInt();
				input.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please enter an intger greater than 0.");
			}
			if (seats >= 1) {
				isEntered = true;
			}
		}

		isEntered = false;

		if (isManual == true) {
			Parties = enterResults();
		} else {

			while (isEntered == false) {
				System.out.println("\nPlease enter the name of a .txt file (remmber to include the .txt at the end):");
				filename = input.nextLine(); // Grabs the next word entered
				input.nextLine();

				// Check if the input ends with .txt (ignoring uppercase/lowercase differences)
				if (filename.toLowerCase().endsWith(".txt")) {
					isEntered = true;
				} else {
					System.err.println("Invalid format. The filename must end with '.txt'.");
					System.out.println("Please try again (e.g., test.txt):");
					input.nextLine();
				}
			}
		}

		displayMenu();
		selection = getSelection();
		while (selection != 'q') {
			if (isManual == true) {
				executeSelection(selection, seats, threshold, Parties);
			} else {
				executeSelection(selection, seats, threshold, filename);
			}
			if (currMethod != null) {
				if (isManual == false) {
					currMethod.loadFile();
					// catch (java.io.FileNotFoundException e)
				}
				currMethod.allocateSeats();
				currMethod.results();
			}
			displayMenu();
			selection = getSelection();
		}
	}

	public ArrayList<Party> enterResults() {
		int number = 0; // The number of Parties.
		int votes = -1; // The number of votes a party got.
		String name = "N/A"; // The name of a party;
		boolean isEntered = false;

		ArrayList<Party> parties = new ArrayList<Party>();

		while (isEntered == false) {
			System.out.println("Please enter the number of parties competing in this election. (The minimum is 1):");
			try {
				number = input.nextInt();
				input.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please enter an integer greater than 0.");
				input.nextLine();
			}
			if (number >= 1) {
				isEntered = true;
			}
		}

		for (int i = 0; i < number; i++) {
			isEntered = false;
			if (i == (number - 1)) {
				System.out.println("Please enter the name of the last party: ");
			} else {
				System.out.println("Now enter the name of a party: ");
			}
			name = input.nextLine();

			while (isEntered == false) {
				System.out.println("And how many votes did " + name + " revice in this election?(At least 0): ");
				try {
					votes = input.nextInt();
					name = input.nextLine();
				} catch (InputMismatchException e) {
					System.err.println("Invalid input. Please enter an intger greater than or equal to 0.");
					name = input.nextLine();
				}
				if (number >= 0) {
					isEntered = true;
				}
			}

			parties.add(new Party(name, votes));
		}

		return parties;
	}

}
