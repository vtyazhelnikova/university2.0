package main.java;
import javax.xml.parsers.DocumentBuilder;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import java.io.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;

public class FileReader {
    public static void main (String [] args)  {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            Document doc = db.parse(new URL("https://my.nsu.ru/public/resp/student-groups/group-list.xvm?facId=0").openStream());
            System.out.println(doc);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
