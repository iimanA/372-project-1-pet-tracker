package main.project1.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class Shelter contains information of a shelter
 *
 * Project 1
 * Class ICS 372
 */
public class Shelter {
    private String shelterId;
    private Boolean inTaking;
    private Map<String, Animal> animalList;

    /**
     * Constructor of a shelter. Set shelter ID to shelterId. By default, shelter will be enabled to receive animals
     * @param shelterId ID of the shelter that you want to create
     *
     */
    public Shelter(String shelterId) {

        this.shelterId = shelterId;
    }

    /**
     * Add animal to the shelter
     * @param animal Animal object of the animal
     *
     */
    public void addAnimal (Animal animal) {
        String key = animal.getId();
        this.animalList.put(key,animal);
    }

    /**
     * Export the current animal list of this shelter to a JSON Object
     * @return JSONObject contains all the animals information
     *
     */
    public JSONObject exportAnimalListJSON () {
        return  exportAnimalListJSON();

    }

    /**
     * Return the animal list
     * @return Map <String, Animal> contains all the animals information
     *
     */
    public Map <String, Animal> getAnimalList () {
        return animalList;
    }

    /**
     * Set inTaking
     * @param value new Boolean value for inTaking
     *
     */

    /**
     * Return current inTaking value
     * @return inTaking
     *
     */
    public void setInTaking (Boolean value) {
        inTaking = true;
    }

    public Boolean getInTaking () {

        this.inTaking = inTaking;
        return inTaking;
    }

    /**
     * Set ID
     * @param shelterId new ID for this shelter
     *
     */


    /**
     * Return this shelter's ID
     * @return shelterID
     *
     */
    public void setShelterId(String id) {
        shelterId = id;
    }
    public String getId() {
        return shelterId;
    }
}

