package project2.domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class JsonIO implements IDataIO{

    /**
     * Read json file in path
     * return an array list of Shelter
     */
    @Override
    public Map<String, Shelter> convert(String fileName) throws IOException, ParseException, FileNotFoundException {
        String filePath = MyPath.getResourcePath(fileName) + ".json";
        Map<String, Shelter> shelterList = new HashMap<>();
        Object obj = new JSONParser().parse(new FileReader(filePath));
        JSONObject jsonObject = (JSONObject) obj;
        for (Object key : jsonObject.keySet()) {
            JSONArray animalList = (JSONArray) jsonObject.get(key);
            for (int i = 0; i < animalList.size(); i++) {
                JSONObject animalJson = (JSONObject) animalList.get(i);
                Animal animal = new Animal(animalJson);
                String shelterId = animal.getShelterId();
                if (shelterList.get(shelterId) == null) {
                    String shelterName = (String) animalJson.get("shelter_name");
                    shelterList.put(shelterId, new Shelter(shelterId, shelterName));
                }
                Shelter shelter = shelterList.get(shelterId);
                shelter.addAnimal (animal);
            }
        }
        return shelterList;
    }

    /**
     * Export Shelter information to a json file, placed in resources
     */
    @Override
    public void dataExport(Map<String, Shelter> shelterList) throws FileNotFoundException {

    }
}
