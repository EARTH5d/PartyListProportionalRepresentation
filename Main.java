
/**
 * Main
 *
 * @author Casey Marshall
 * @version 5/24/2026
 */
import java.util.*;
import java.io.*;
//import java.lang.Math;

public class Main {
	// instance variables - replace the example below with your own

	public static void main(String[] args) throws IOException {
		String filename = "fictional-1.txt";

		int seats = 0;
		double threshold = 0.04;
		boolean isEntered = false;
		Scanner input = new Scanner(System.in);

		// ArrayList<Party> Parties = new ArrayList<Party>();

		while (isEntered == false) {
			System.out.println("Please the number of seat up this election. (The minimum is 1.) :");
			try {
				seats = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please enter an intger greater than 0.");
			}
			if (seats >= 1) {
				isEntered = true;
			}
		}

		// Parties = enterResults();

		DroopHA election1 = new DroopHA(seats, threshold, filename);
		DHondtHA election2 = new DHondtHA(seats, threshold, filename);
		WebsterHA election3 = new WebsterHA(seats, threshold, filename);
		AdamHA election4 = new AdamHA(seats, threshold, filename);
		HuntingtonHillHA election5 = new HuntingtonHillHA(seats, threshold, filename);
		DroopLR election6 = new DroopLR(seats, threshold, filename);
		HareLR election7 = new HareLR(seats, threshold, filename);
		ImperialiLR imperialiLR = new ImperialiLR(seats, threshold, filename);
		DroopLR_Sq election8 = new DroopLR_Sq(seats, threshold, filename);

		System.out.println("Highest Average Methods");
		System.out.println("Droop:");
		election1.loadFile();
		election1.allocateSeats();
		election1.results();
		System.out.println("DHondt:");
		election2.loadFile();
		election2.allocateSeats();
		election2.results();
		System.out.println("Wedster:");
		election3.loadFile();
		election3.allocateSeats();
		election3.results();
		System.out.println("Adam's:");
		election4.loadFile();
		election4.allocateSeats();
		election4.results();
		System.out.println("Huntington-Hill:");
		election5.loadFile();
		election5.allocateSeats();
		election5.results();
		System.out.println("Largest Remiander Methods");
		System.out.println("Droop:");
		election6.loadFile();
		election6.allocateSeats();
		election6.results();
		System.out.println("Hare:");
		election7.loadFile();
		election7.allocateSeats();
		election7.results();
		System.out.println("Imperiali");
		imperialiLR.loadFile();
		imperialiLR.allocateSeats();
		imperialiLR.results();
		System.out
				.println(
						"Droop_Sq (If all leftover seats have not been allocated to a Party, then conduct another round of allocation with the original votes apply to the remainding seats):");
		election8.loadFile();
		election8.allocateSeats();
		election8.results();
	}

	public static ArrayList<Party> enterResults() {
		int number = 0; // The number of Parties.
		int votes = -1; // The number of votes a party got.
		String name = "N/A"; // The name of a party;
		boolean isEntered = false;
		Scanner input = new Scanner(System.in);

		ArrayList<Party> parties = new ArrayList<Party>();

		while (isEntered == false) {
			System.out.println("Please the number of parties competing in this election. (The minimum is 1.) :");
			try {
				number = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please enter an intger greater than 0.");
			}
			if (number >= 1) {
				isEntered = true;
			}
		}

		name = input.nextLine();
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
				} catch (InputMismatchException e) {
					System.err.println("Invalid input. Please enter an intger greater than or equal to 0.");
				}
				if (number >= 0) {
					isEntered = true;
				}
			}

			parties.add(new Party(name, votes));
			name = input.nextLine();
		}

		return parties;
	}

}
