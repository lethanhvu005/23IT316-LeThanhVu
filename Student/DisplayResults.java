package Student;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DisplayResults {

    public static void main(String[] args) {
        displayResults("C:\\Users\\This PC\\eclipse-workspace\\bt6\\kq.xml");
    }

    private static void displayResults(String filePath) {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList studentList = doc.getElementsByTagName("student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Element studentElement = (Element) studentList.item(i);
                String id = studentElement.getAttribute("id");
                String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                String address = studentElement.getElementsByTagName("address").item(0).getTextContent();
                String dob = studentElement.getElementsByTagName("dob").item(0).getTextContent();
                String age = studentElement.getElementsByTagName("age").item(0).getTextContent();
                String encodedAge = studentElement.getElementsByTagName("encodedAge").item(0).getTextContent();
                String isDigitPrime = studentElement.getElementsByTagName("isDigitPrime").item(0).getTextContent();
                
                System.out.println("Student ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Date of Birth: " + dob);
                System.out.println("Age: " + age);
                System.out.println("Encoded Age: " + encodedAge);
                System.out.println("Is Digit Prime: " + isDigitPrime);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
