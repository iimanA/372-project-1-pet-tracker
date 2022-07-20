package project2.domain;

import java.text.SimpleDateFormat;
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
        private static String filePath = MyPath.getResourcePath(fileName) + ".xml";;

    public static void main(String[] args) {
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        try {

            SAXBuilder sax = new SAXBuilder();
            // XML is a local file
            Document doc = sax.build(new File(filePath));

            Element rootNode = doc.getRootElement();
            List<Element> list = (List<Element>) rootNode.getChildren("Animal");

            for (Element target : list) {
                Animal thisAnimal = new Animal(); //creates animal to add to arraylist
                /** the following segment gets the info about the animal from the
                 * xml file
                 */
                String type = target.getAttributeValue("type");
                String id = target.getAttributeValue("id");
                String weightUnit = target.getAttributeValue("unit");
                String Weight = target.getChildText("Weight");
                String name = target.getChildText("name");
                String ReceiptDate = target.getChildText("ReceiptDate");

                float flWeight = Float.parseFloat(Weight); //parses the weight string into a float
                Long lReceiptDate = Long.parseLong(ReceiptDate);// get the date in correct format
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                Date dateReceipt = dateFormat.parse(lReceiptDate.toString());
                if (weightUnit == "kg") {
                    flWeight = (float) (flWeight * 2.2);
                }
                else {
                    flWeight = flWeight;
                }
                //adds info pulled from xml into the animal object
                thisAnimal.setName(name);
                thisAnimal.setAnimalId(id);
                thisAnimal.setWeight(flWeight);
                thisAnimal.setAnimalType(type);
                thisAnimal.setReceiptDate(dateReceipt);
                animalList.add(thisAnimal);//adds the newly pulled animal to the animal arraylist

            }
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
    }
        /**
    @Override
    public ArrayList<Shelter> convert(String path) {

        return null;
    }
    */
    /**
     * Export Shelter information to a xml file, placed in resources
 */
        public void dataExport(Shelter shelter) throws IOException {
        ArrayList<Animal> shelterResidents = shelter.getAnimalList();
        Document doc = new Document();
        doc.setRootElement(new Element("Shelter"));
        for (int i = 0; i < shelterResidents.size(); i++) {
            Animal currentAnim = shelterResidents.get(i);
            Element Animal = new Element("Animal");
            Animal.setAttribute("type",currentAnim.getAnimalType());
            Animal.setAttribute("id",currentAnim.getAnimalId());
            Animal.addContent(new Element("Weight").setText(currentAnim.getWeight()));
            Animal.addContent(new Element("name").setText(currentAnim.getName()));
            Animal.addContent(new Element("ReceiptDate").setText(currentAnim.getReceiptDate()));
        }
            XMLOutputter xmlOutputter = new XMLOutputter();
            try(FileOutputStream fileOutputStream =
                        new FileOutputStream("src/main/resources/project2")){
                xmlOutputter.output(new Document(), fileOutputStream);
            }
        }
    }

