package project2.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlIO implements IDataIO{
    /**
     * Read xml file in path
     * return an array list of Shelter
     */
    @Override
    public Map<String, Shelter> convert(String fileName) throws IOException, ParseException, FileNotFoundException {
        String filePath = MyPath.getResourcePath(fileName) + ".xml";
        return null;
    }

    /**
     * Export Shelter information to a xml file, placed in resources
     */
    @Override
    public void dataExport(Map<String, Shelter> shelterList) throws FileNotFoundException {

    }
}
