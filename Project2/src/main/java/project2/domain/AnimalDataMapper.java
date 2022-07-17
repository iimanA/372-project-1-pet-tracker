package project2.domain;

import java.util.Date;
import java.util.List;

public class AnimalDataMapper implements IAnimalDataMapper{
    /**
     * get information from Animal Database and Animal_Shelter database
     * return as an Animal object
     *
     * @return Animal object
     */

    @Override
    public Animal get(String animalId) {

        return null;
    }

    /**
     * update animal information in Animal Database and Animal_Shelter database
     */
    @Override
    public void update(Animal animal) {
        //Isn't required for this project
    }

    /**
     * insert a new animal to Animal Database and Animal_Shelter database
     */
    @Override
    public void insert(Animal animal) {

    }

    @Override
    public void delete(String animalId) {
        //Isn't required for this project
    }

}
