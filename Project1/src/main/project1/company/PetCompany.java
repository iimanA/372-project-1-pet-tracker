package main.project1.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
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
        Path resourceDirectory = Path.of("src", "resources", fileName);
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.out.println (absolutePath);
        try {
            Object obj = new JSONParser().parse(new FileReader(absolutePath));
            JSONObject jo = (JSONObject) obj;
            System.out.println(jo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    public static void main (String[] args) {
//        PetCompany company = new PetCompany("Project1_input.json");
//    }
}
