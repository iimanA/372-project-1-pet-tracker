package main.project1.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import main.project1.company.Shelter;

public class PetCompany {
    private Map<String, Shelter> shelterList;

    public PetCompany() {
        shelterList = new HashMap<String, Shelter>();
    }

    public PetCompany(String fileName) {
        shelterList = new HashMap<String, Shelter>();
        addAnimal(fileName);
    }

    public void addAnimal (String fileName) {
        Path resourceDirectory = Path.of("src", "resources", fileName);
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
//        System.out.println (absolutePath);
        try {
            Object obj = new JSONParser().parse(new FileReader(absolutePath));
            JSONObject jsonObject = (JSONObject) obj;
            for (Object key : jsonObject.keySet()) {
                JSONArray animalList = (JSONArray) jsonObject.get(key);
                for (int i = 0; i < animalList.size(); i++) {
                    JSONObject animalJson = (JSONObject) animalList.get(i);
                    Animal animal = new Animal(animalJson);
                    String shelterId = animal.getShelterId();
                    if (shelterList.get(shelterId) == null) {
                        shelterList.put(shelterId, new Shelter(shelterId));
                    }
                    Shelter shelter = shelterList.get(shelterId);
                    shelter.addAnimal (animal);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void enableReceivingAnimal (String shelterId) {
        Shelter shelter = shelterList.get(shelterId);
        shelter.setInTaking (true);
    }

    public void disableReceivingAnimal (String shelterId) {
        Shelter shelter = shelterList.get(shelterId);
        shelter.setInTaking (false);
    }

    public JSONObject exportAnimalListJSON (String shelterId) {
        Shelter shelter = shelterList.get(shelterId);
        return shelter.exportAnimalListJSON ();
    }

    public ArrayList <Animal> showAnimalList (String shelterId) {
        Shelter shelter = shelterList.get(shelterId);
        return shelter.getAnimalList ();
    }

//    public static void main (String[] args) {
//        PetCompany company = new PetCompany("Project1_input.json");
//    }
}
