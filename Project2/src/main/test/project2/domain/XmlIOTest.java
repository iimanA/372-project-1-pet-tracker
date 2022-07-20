package project2.domain;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class XmlIOTest {

    @Test
    public void convert() {
        XmlIO xmlIO = new XmlIO();
        try {
            Map<String, Shelter> shelterGet = xmlIO.convert("test_xml");
            assertEquals(shelterGet.get("09876").getName(), "Test Shelter");
            assertEquals(shelterGet.get("09876").getAnimalList().size(), 1);
            Map<String, Animal> animalMap = shelterGet.get("09876").getAnimalList();
            assertEquals(animalMap.get("abcdef").getName(), "Mopsy");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void dataExport() {
    }
}