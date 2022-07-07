package project2.domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class Shelter contains information of a shelter
 * Iiman
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
        this.inTaking = true;
        animalList = new HashMap<> ();
    }

    /**
     * Add animal to the shelter
     * @param animal Animal object of the animal
     *
     */
    public void addAnimal (Animal animal) {
        String key = animal.getAnimalId();
        if (inTaking) {
            this.animalList.put(key, animal);
        } else {
            System.out.printf("Cannot add animal id %s: shelter id %s has stopped receiving animal \n", animal.getAnimalId(), shelterId);
        }
    }

    /**
     * Export the current animal list of this shelter to a JSON Object
     * @return JSONObject contains all the animals information
     *
     */
    public JSONObject exportAnimalListJSON () {
        JSONArray animalJSONArray = new JSONArray();
        for (String animalId : animalList.keySet()) {
            Animal animal = animalList.get(animalId);
            LinkedHashMap<String,Object> animalJSON = new LinkedHashMap<>();
            animalJSON.put("shelter_id", animal.getShelterId());
            animalJSON.put("animal_type", animal.getAnimalType());
            animalJSON.put("animal_name", animal.getName());
            animalJSON.put("animal_id", animal.getAnimalId());
            animalJSON.put("weight", animal.getWeight());
            animalJSON.put("receipt_date", animal.getReceiptDate().getTime());
            animalJSONArray.add(animalJSON);
        }
        JSONObject animalListJSON = new JSONObject();
        animalListJSON.put("shelter_" + shelterId, animalJSONArray);
        return animalListJSON;
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
    public void setInTaking (Boolean value) {
        inTaking = value;
    }

    /**
     * Return current inTaking value
     * @return inTaking
     *
     */
    public Boolean getInTaking () {
        return inTaking;
    }

    /**
     * Set ID
     * @param id new ID for this shelter
     *
     */
    public void setShelterId(String id) {
        shelterId = id;
    }

    /**
     * Return this shelter's ID
     * @return shelterID
     *
     */
    public String getId() {
        return shelterId;
    }
}

