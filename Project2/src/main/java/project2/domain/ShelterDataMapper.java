package project2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShelterDataMapper implements IShelterDataMapper{
    /**
     * get information from Shelter Database and Animal_Shelter database
     * return as a Shelter object
     *
     * @return Shelter object
     */
    @Override
    public Shelter get(String shelterId) {

        return null;
    }

    /**
     * update shelter information in Shelter Database and Animal_Shelter database
     */
    @Override
    public void update(Shelter shelter) {

    }

    /**
     * insert a new shelter to Shelter Database and Animal_Shelter database
     */
    @Override
    public void insert(Shelter shelter) {

    }

    @Override
    public void delete(String shelterId) {
        //Isn't required for this project
    }

    public Map<String, Shelter> getShelterList () {
        return null;
    }

    private Map<String, Animal> getAnimalList (String shelterId) {

        return null;
    }

}
