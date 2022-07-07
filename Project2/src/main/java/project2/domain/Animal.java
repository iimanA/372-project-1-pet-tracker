package project2.domain;

import org.json.simple.JSONObject;

import java.util.Date;


/**
 * Class Animal contains information of an animal
 * Emma
 * Project 1
 * Class ICS 372
 */
public class Animal {
    private String name;
    private String animalId;
    private float weight;
    private String shelterId;
    private String animalType;
    private Date receiptDate;


    /**
     * Constructor of an animal
     *
     * @param animalJson a JSONObject contains animal information
     */
    public Animal(JSONObject animalJson) {
        this.name = (String) animalJson.get("animal_name");
        this.animalId = (String) animalJson.get("animal_id");
        String weightString = String.valueOf(animalJson.get("weight"));
        this.weight = Float.parseFloat(weightString);
        this.shelterId = (String) animalJson.get("shelter_id");
        this.animalType = (String) animalJson.get("animal_type");
        this.receiptDate = new Date((long) animalJson.get("receipt_date"));
    }

    public Animal (String name, String animalId, float weight, String shelterId, String animalType, Date receiptDate) {
        this.name = name;
        this.animalId = animalId;
        this.weight = weight;
        this.shelterId = shelterId;
        this.animalType = animalType;
        this.receiptDate = receiptDate;
    }


    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }


    public String getAnimalId() {
        return animalId;
    }


    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }


    public String getShelterId() {
        return shelterId;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }



    public Date getReceiptDate() {
        return receiptDate;
    }


    public void setWeight(float weight) {
        this.weight = weight;
    }


    public float getWeight() {
        return weight;
    }



    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }



    public String getAnimalType() {
        return animalType;
    }

} //end of animal class



