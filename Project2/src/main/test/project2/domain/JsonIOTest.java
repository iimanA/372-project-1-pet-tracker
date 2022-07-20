package project2.domain;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonIOTest {

    @Test
    public void convert() {
        JsonIO jsonIO = new JsonIO();
        try {
            Map<String, Shelter> shelterGet = jsonIO.convert("test_json");
            assertEquals(shelterGet.get("54321").getName(), "Test Shelter");
            assertEquals(shelterGet.get("54321").getAnimalList().size(), 1);
            Map<String, Animal> animalMap = shelterGet.get("54321").getAnimalList();
            assertEquals(animalMap.get("abcd").getName(), "Lucky");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void dataExport() {
    }
}