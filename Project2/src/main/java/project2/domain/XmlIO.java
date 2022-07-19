package project2.domain;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.io.FileOutputStream;

import jdk.internal.icu.text.UnicodeSet;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.util.List;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XmlIO implements IDataIO{
    /**
     * Read xml file in path
     * return an array list of Shelter
     */
        private static String FILENAME = "src/main/resources/project2/sample.xml";

    public static void main(String[] args) {
        ArrayList<Animal> animalList= new ArrayList<Animal>();
        try {

            SAXBuilder sax = new SAXBuilder();
            // XML is a local file
            Document doc = sax.build(new File(FILENAME));

            Element rootNode = doc.getRootElement();
            List<Element> list = (List<Element>) rootNode.getChildren("Animal");

            for (Element target : list) {
                Animal thisAnimal = new Animal(); //creates animal to add to arraylist
                /** the following segment gets the info about the animal from the
                 * xml file
                 */
              String type = target.getAttributeValue("type");
              String id = target.getAttributeValue("id");
              String Weight = target.getChildText("Weight");
              String name = target.getChildText("name");
              Date ReceiptDate = target.getChildText("ReceiptDate");
              float flWeight = Float.parseFloat(Weight); //parses the weight string into a float

                //adds info pulled from xml into the animal object
              thisAnimal.setName(name);
              thisAnimal.setAnimalId(id);
              thisAnimal.setWeight(flWeight);
              thisAnimal.setAnimalType(type);
              thisAnimal.setReceiptDate(ReceiptDate);
              animalList.add(thisAnimal);//adds the newly pulled animal to the animal arraylist

            }
            }  catch (IOException | JDOMException e) {
            e.printStackTrace(); }
        /**
    @Override
    public ArrayList<Shelter> convert(String path) {

        return null;
    }
    */
    /**
     * Export Shelter information to a xml file, placed in resources
 */
    @Override
    public void dataExport(Shelter shelter) throws IOException {
        ArrayList<Animal> shelterResidents = shelter.getAnimalList();
        Document doc = new Document();
        doc.setRootElement(new Element("Shelter"));
        for (int i = 0; i < shelterResidents.size(); i++) {
            Element Animal = new Element("Animal");
            Animal.setAttribute("type",this.getAnimalType());
            Animal.setAttribute("id",this.getAnimalId());
            Animal.addContent(new Element("Weight").setText(this.getWeight()));
            Animal.addContent(new Element("name").setText(this.getName()));
            Animal.addContent(new Element("ReceiptDate").setText(this.getReceiptDate()));
        }
            XMLOutputter xmlOutputter = new XMLOutputter();
            try(FileOutputStream fileOutputStream =
                        new FileOutputStream("src/main/resources/project2")){
                xmlOutputter.output(new Document(), fileOutputStream);
            }
        }
    }
}
