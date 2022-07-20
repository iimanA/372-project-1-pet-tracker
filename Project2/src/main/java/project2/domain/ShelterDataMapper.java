package project2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShelterDataMapper implements IShelterDataMapper, Serializable{
    
     private HashMap <String, Shelter> sList;
    private static final long serialVersionUID = 43L;
    
    public ShelterDataMapper() {
        sList = new Hashmap<String,Shelter>();
        
        public ShelterDataMapper(String fileName) {
        try {
            fileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this = (ShelterDataMapper) in.readObject();
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
     * get information from Shelter Database and Animal_Shelter database
     * return as a Shelter object
     *
     * @return Shelter object
     */
    @Override
    public Shelter get(String shelterId) {

        return sList.get(shelterId);;
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
        sList.put(Shelter.getShelterId(), shelter);
    }

    @Override
    public void delete(String shelterId) {
        //Isn't required for this project
    }

    public Map<String, Shelter> getShelterList () {
        return sList;
    }

    private Map<String, Animal> getAnimalList (String shelterId) {

        return sList.get(shelterId).getAnimalList();
    }

}
