[200~package main.project1.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.project1.company.Animal;
import main.project1.company.PetCompany;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class UserInterface will interact with user to provide the functionalities
 * that they want
 *
 * Project 1 Class ICS 372
 */
public class UserInterface {
	private static UserInterface userInterface;
	private PetCompany company;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static final int QUIT = 0;
	private static final int ADD_ANIMAL = 1;
	private static final int ENABLE_RECIEVING_ANIMAL = 2;
	private static final int DISABLE_RECIEVING_ANIMAL = 3;
	private static final int EXPORT_ANIMALS = 4;
	private static final int SHOW_ANIMAL_LIST = 5;
	private static final int MENU = 6;
	private static final char[] Null = null;

	/**
	 * Constructor for UserInterface. Will create an object of PetCompany and load
	 * information from our sample input "Project1_input.json" when started
	 *
	 */
	public static UserInterface instance() {
		if (userInterface == null) {
			return userInterface = new UserInterface();
		} else {
			return userInterface;
		}
	}

	/**
	 * Show all the functionalities that the program can provide - Type 1 to add new
	 * animal to our shelter - Type 2 to enable receiving animal for a shelter -
	 * Type 3 to disable receiving animal for a shelter - Type 4 to export all
	 * animals from a shelter into a single JSON file - Type 5 to show the list of
	 * current animals for each shelter - Type 0 to quit
	 *
	 */
	public void showMenu() {
		System.out.println("Enter a number between 0 and 6 as explained below:");
		System.out.println(QUIT + " to Quit\n");
		System.out.println(ADD_ANIMAL + " to add new animal to our shelter");
		System.out.println(ENABLE_RECIEVING_ANIMAL + " to Enable receiving animal for a shelter");
		System.out.println(DISABLE_RECIEVING_ANIMAL + " to disable receiving animal for a shelter");
		System.out.println(EXPORT_ANIMALS + " to export all animals from a shelter into a single JSON file");
		System.out.println(SHOW_ANIMAL_LIST + " to show the list of current animals for each shelter ");
		System.out.println(MENU + " to retrieve menu again");

	}

	/**
	 * Take file name from user and call method addAnimal to add animal to the
	 * shelters File should be placed under resources folder and should have the
	 * same format as the sample JSON input
	 * 
	 * @catch IOException, ParseException, ClassCastException
	 *
	 */
	public void addAnimal() {
		String name = getToken("Enter file name");
		try {
			company.addAnimal(name);
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Take shelter ID from user and call method enableReceivingAnimal from
	 * PetCompany to enable shelter receiving animal If the shelter ID is invalid,
	 * inform the user
	 *
	 */
	public void enableReceivingAnimal() {
		int result;
		String shelterId = getToken("Enter Shelter ID");
		result = company.enableReceivingAnimal(shelterId);
		if (result == 0) {
			System.out.println("Success: Sheter ID Vaild");
		} else {
			System.out.println("Failed: Sheter ID Invaild");
		}
	}

	/**
	 * Take shelter ID from user and call method disableReceivingAnimal from
	 * PetCompany to disable shelter receiving animal If the shelter ID is invalid,
	 * inform the user
	 *
	 */
	public void disableReceivingAnimal() {
		int result;
		String shelterId = getToken("Enter Shelter ID");
		result = company.disableReceivingAnimal(shelterId);
		if (result == 0) {
			System.out.println("Success: Sheter ID Vaild");
		} else {
			System.out.println("Failed: Sheter ID Invaild");
		}
	}

	/**
	 * Take shelter ID from user and call method exportAnimalListJSON from
	 * PetCompany to get the JSONObject object If the shelter ID is invalid, inform
	 * the user Print the JSONObject to the screen
	 *
	 */
	public void exportAnimalListJSON() {
		JSONObject result;
		String shelterId = getToken("Enter Shelter ID");
		result = company.exportAnimalListJSON(shelterId);
		if (result != null) {
			System.out.println(result); // COME BACK TO MEE
		} else {
			System.out.println("Failed: Sheter ID Invaild");
		}
	}

	/**
	 * Take shelter ID from user and call method showAnimalList from PetCompany to
	 * get the list of animals If the shelter ID is invalid, inform the user Print
	 * the list of animals to the screen in a nice way
	 *
	 */
	public void showAnimalList() {
		Map<String, Animal> result;
		String shelterId = getToken("Enter Shelter ID");
		result = company.showAnimalList(shelterId);
		if (result != null) {
			for (Map.Entry<String, Animal> entry : result.entrySet())
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		} else {
			System.out.println("Failed: Sheter ID Invaild");
		}
	}

	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}

	public int getCommand() {
		do {
			try {
				int value = Integer.parseInt(getToken("Enter command:" + MENU + " for Menu"));
				if (value >= QUIT && value <= MENU) {
					return value;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Enter a number");
			}
		} while (true);
	}

	/**
	 * Main method to run the program An infinite loop of querying until the user
	 * type 0
	 * 
	 */
	public void run() {
		int command;
		while ((command = getCommand()) != QUIT) {
			switch (command) {
			case ADD_ANIMAL:
				addAnimal();
				break;
			case ENABLE_RECIEVING_ANIMAL:
				enableReceivingAnimal();
				break;
			case DISABLE_RECIEVING_ANIMAL:
				disableReceivingAnimal();
				break;
			case EXPORT_ANIMALS:
				exportAnimalListJSON();
				break;
			case SHOW_ANIMAL_LIST:
				showAnimalList();
				break;
			case MENU:
				showMenu();
				break;
			}
		}

	}

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.run();
	}
}

