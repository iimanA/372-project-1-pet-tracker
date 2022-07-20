package project2.domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonIO implements IDataIO{

    /**
     * Read json file in path
     * return an array list of Shelter
     */
    @Override
    public Map<String, Shelter> convert(String fileName) throws IOException, ParseException, FileNotFoundException {
        String filePath = MyPath.getResourcePath(fileName) + ".json";
        return null;
    }
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader()) {

        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        String shelterId = (String) jsonObject.get("shelter_Id");
        String shelter_name = (String) jsonObject.get("shelter_name");
        String animalType = (String) jsonObject.get("animal_Type");
        String animalId = (String) jsonObject.get("animal_Id");
        float weight = (float) jsonObject.get("weight");
        Date receiptDate = (Date) jsonObject.get("receipt_date");


    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }

    /**
     * Export Shelter information to a json file, placed in resources
     */
    @Override
    public void dataExport(Map<String, Shelter> shelterList) throws FileNotFoundException {

    }
}
