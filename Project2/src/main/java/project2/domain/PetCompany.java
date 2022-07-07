package project2.domain;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * Class PetCompany contains information about all the shelters that company has using a HashMap of Shelter
 * Each shelter has a unique ID
 *
 * @author Dung Thi Thuy Ha
 * Project 1
 * Class ICS 372
 */
public class PetCompany {

    /**
     * Constructor for PetCompany. Will load infor from a JSON file and create a shelterList objects contains
     * information of all shelters and animals in that JSON
     *
     * @param fileName name of the file that will be used as input. This file should be placed under resources folder
     */
    public PetCompany() {
//        shelterList = new HashMap<>();
//        try {
//            addAnimal(fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (ClassCastException e) {
//            e.printStackTrace();
//        }
    }


    /**
     * Load information of animal from JSON file and add new animals to our current shelter list.
     *
     * @param fileName name of the file that will be used as input. This file should be placed under resources folder
     * @throws IOException if the file is not accessible
     * @throws ParseException if the file doesnt have the same format as the sample file
     * @throws ClassCastException if the file doesnt have the same format as the sample file
     *
     */
    public void addAnimal (String fileName, String type) throws IOException, ParseException, ClassCastException{
        Path resourceDirectory = Path.of("src", "resources", fileName);
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        IDataIO fileData = DataIOFactory.get (type);
        ArrayList <Shelter> shelterList = fileData.convert (absolutePath);
        IAnimalDataMapper animalDataMapper = new AnimalDataMapper();
        for (int i = 0; i < shelterList.size(); i++) {
            Map <String, Animal> animalList = shelterList.get(i).getAnimalList();
            for (String key : animalList.keySet())  {
                animalDataMapper.insert (animalList.get(key));
            }
        }
    }

    /**
     * Enable shelter with ID shelterId to receive animal
     *
     * @param shelterId ID of the shelter that should be enabled for receving animal
     * @return 0 if the shelter ID is valid
     * @return -1 if the shelter ID is invalid
     *
     */
    public int enableReceivingAnimal (String shelterId) {
        IShelterDataMapper shelterDataMapper = new ShelterDataMapper();
        Shelter shelter = shelterDataMapper.get (shelterId);
        if (shelter == null) return -1;
        shelter.setInTaking (true);
        shelterDataMapper.update (shelter);
        return 0;
    }

    /**
     * Disable shelter with ID shelterId to receive animal
     *
     * @param shelterId ID of the shelter that should be disabled for receving animal
     * @return 0 if the shelter ID is valid
     * @return -1 if the shelter ID is invalid
     *
     */
    public int disableReceivingAnimal (String shelterId) {
        IShelterDataMapper shelterDataMapper = new ShelterDataMapper();
        Shelter shelter = shelterDataMapper.get (shelterId);
        if (shelter == null) return -1;
        shelter.setInTaking (false);
        shelterDataMapper.update (shelter);
        return 0;
    }

    /**
     * Export all animals in shelter with ID shelterId to a JSONObject
     *
     * @param shelterId ID of the shelter that should be export
     * @return JSONObject of the list of animals in the shelter
     * @return null if the shelter ID doesn't exist
     *
     */
    public int exportAnimalList (String shelterId, String type) {
        IShelterDataMapper shelterDataMapper = new ShelterDataMapper();
        Shelter shelter = shelterDataMapper.get (shelterId);
        if (shelter == null) return -1;
        IDataIO dataIO = DataIOFactory.get(type);
        dataIO.dataExport (shelter);
        return 0;
    }

    /**
     * Return the list of all animals in shelter with ID shelterId
     *
     * @param shelterId ID of the shelter that needs to show animal list
     * @return a Map <String, Animal> contains all the animal of shelterId
     * @return null if the shelter ID doesn't exist
     *
     */
    public Map <String, Animal> showAnimalList (String shelterId) {
        IShelterDataMapper shelterDataMapper = new ShelterDataMapper();
        Shelter shelter = shelterDataMapper.get (shelterId);
        if (shelter == null) return null;
        return shelter.getAnimalList ();
    }

    public Animal getAnimalInfo (String animalId) {
        IShelterDataMapper shelterDataMapper = new ShelterDataMapper();
        Map <String, Shelter> shelterList = shelterDataMapper.getShelterList ();
        for (String key : shelterList.keySet()) {
            Shelter shelter = shelterList.get(key);
            Map <String, Animal> animalList = shelter.getAnimalList();
            if (animalList.get(animalId) != null) {
                return animalList.get(animalId);
            }
        }
        return null;
    }

    public Shelter getShelterInfo (String shelterId) {
        IShelterDataMapper shelterDataMapper = new ShelterDataMapper();
        Shelter shelter = shelterDataMapper.get (shelterId);
        return shelter;
    }
}
