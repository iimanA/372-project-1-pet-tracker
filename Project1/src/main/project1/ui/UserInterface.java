package main.project1.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.project1.company.Animal;
import main.project1.company.PetCompany;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Class UserInterface will interact with user to provide the functionalities that they want
 *
 * Project 1
 * Class ICS 372
 */
public class UserInterface {
    private PetCompany company;

    /**
     * Constructor for UserInterface. Will create an object of PetCompany and load
     * information from our sample input "Project1_input.json" when started
     *
     */
    public UserInterface () {

    }

    /**
     * Show all the functionalities that the program can provide
     *  - Type 1 to add new animal to our shelter
     *  - Type 2 to enable receiving animal for a shelter
     *  - Type 3 to disable receiving animal for a shelter
     *  - Type 4 to export all animals from a shelter into a single JSON file
     *  - Type 5 to show the list of current animals for each shelter
     *  - Type 0 to quit
     *
     */
    public void showMenu () {

    }

    /**
     * Take file name from user and call method addAnimal to add animal to the shelters
     * File should be placed under resources folder and should have the same format as the sample JSON input
     * @catch IOException, ParseException, ClassCastException
     *
     */
    public void addAnimal () {

    }

    /**
     * Take shelter ID from user and call method enableReceivingAnimal from PetCompany to enable shelter receiving animal
     * If the shelter ID is invalid, inform the user
     *
     */
    public void enableReceivingAnimal () {

    }

    /**
     * Take shelter ID from user and call method disableReceivingAnimal from PetCompany to disable shelter receiving animal
     * If the shelter ID is invalid, inform the user
     *
     */
    public void disableReceivingAnimal () {

    }

    /**
     * Take shelter ID from user and call method exportAnimalListJSON from PetCompany to get the JSONObject object
     * If the shelter ID is invalid, inform the user
     * Print the JSONObject to the screen
     *
     */
    public void exportAnimalListJSON () {

    }

    /**
     * Take shelter ID from user and call method showAnimalList from PetCompany to get the list of animals
     * If the shelter ID is invalid, inform the user
     * Print the list of animals to the screen in a nice way
     *
     */
    public void showAnimalList () {

    }

    /**
     * Main method to run the program
     * An infinite loop of querying until the user type 0
     *
     */
    public void run () {

    }

    public static void main (String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}
