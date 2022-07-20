package project2.domain;

import java.util.Date;
import java.util.List;
import java.util.HashMap;

public class AnimalDataMapper implements IAnimalDataMapper, Serializable{
      
  	private HashMap <String, Animal> aList;
  	private static final long serialVersionUID = 42L;
	
  
  
  	public AnimalDataMapper() {
   		aList = new Hashmap<String,Animal>();
    }
  
  	public AnimalDataMapper(String fileName) {
      try {
        fileInputStream fileIn = new FileInputStream(fileName);
       	ObjectInputStream in = new ObjectInputStream(fileIn);
        this = (AnimalDataMapper) in.readObject();
        in.close();
        fileIn.close();
        
      } catch(Exception e) {
        e.printStackTrace();
    
      } 
      
    }
  
  	public void serialize(String fileName) {
      try {
        fileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
      } catch(IOException e) {
         e.printStackTrace();
      }
    }
  
  
  	/**
     * get information from Animal Database and Animal_Shelter database
     * return as an Animal object
     *
     * @return Animal object
     */
    @Override
    public Animal get(String animalId) {

        return aList.get(animalId);
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
		aList.put(animal.getAnimalId(), animal);
    }

    @Override
    public void delete(String animalId) {
        //Isn't required for this project
    }

}
