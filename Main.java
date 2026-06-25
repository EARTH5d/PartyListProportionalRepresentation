
/**
 * Main
 *
 * @author Casey Marshall
 * @version 6/22/2026
 */
import java.util.*;
import java.io.*;
//import java.lang.Math;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		Controller controller = new Controller(input);
		controller.run();

		// Parties = enterResults();

		// DroopHA election1 = new DroopHA(seats, threshold, filename);
		// DHondtHA election2 = new DHondtHA(seats, threshold, filename);
		// WebsterHA election3 = new WebsterHA(seats, threshold, filename);
		// AdamHA election4 = new AdamHA(seats, threshold, filename);
		// HuntingtonHillHA election5 = new HuntingtonHillHA(seats, threshold,
		// filename);
		// DroopLR election6 = new DroopLR(seats, threshold, filename);
		// HareLR election7 = new HareLR(seats, threshold, filename);
		// ImperialiLR imperialiLR = new ImperialiLR(seats, threshold, filename);
		// DroopLR_Sq election8 = new DroopLR_Sq(seats, threshold, filename);
		// SouthAfricanMethod SouthAfrica = new SouthAfricanMethod(seats, threshold,
		// filename, 0);

		// System.out.println("Highest Average Methods");
		// System.out.println("Droop:");
		// election1.loadFile();
		// election1.allocateSeats();
		// election1.results();
		// System.out.println("DHondt:");
		// election2.loadFile();
		// election2.allocateSeats();
		// election2.results();
		// System.out.println("Wedster:");
		// election3.loadFile();
		// election3.allocateSeats();
		// election3.results();
		// System.out.println("Adam's:");
		// election4.loadFile();
		// election4.allocateSeats();
		// election4.results();
		// System.out.println("Huntington-Hill:");
		// election5.loadFile();
		// election5.allocateSeats();
		// election5.results();
		// System.out.println("Largest Remiander Methods");
		// System.out.println("Droop:");
		// election6.loadFile();
		// election6.allocateSeats();
		// election6.results();
		// System.out.println("Hare:");
		// election7.loadFile();
		// election7.allocateSeats();
		// election7.results();
		// System.out.println("Imperiali");
		// imperialiLR.loadFile();
		// imperialiLR.allocateSeats();
		// imperialiLR.results();
		// System.out.println(
		// "Droop_Sq (If all leftover seats have not been allocated to a Party, then
		// conduct another round of allocation with the original votes apply to the
		// remainding seats):");
		// election8.loadFile();
		// election8.allocateSeats();
		// election8.results();
		// System.out.println("Hybird");
		// System.out.println("South African Method");
		// SouthAfrica.loadFile();
		// SouthAfrica.allocateSeats();
		// SouthAfrica.results();
	}

}
