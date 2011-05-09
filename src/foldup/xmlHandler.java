package foldup;
import java.io.IOException;
//Parser packages
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

// DOM Packages
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 *
 * @author evan
 */
public class xmlHandler {
         Document dom;
         Element root;

         /**
          *
          * @param fileName
          */
         public xmlHandler(String fileName){
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

             try {
                 DocumentBuilder db = dbf.newDocumentBuilder();
                 dom = db.parse(fileName);
                 root = dom.getDocumentElement();
             }
             catch(ParserConfigurationException e) {
                 e.printStackTrace();
             }
             catch(SAXException e){
                 e.printStackTrace();
             }
             catch(IOException e){
                 e.printStackTrace();
             }
         }

         /**
          *
          * @param tagName
          * @return String tagValue;
          */
         public String getTextValue(String tagName) {
             String tagValue = null;
             Element ele = (Element)dom.getElementsByTagName(tagName);
             tagValue = ele.getTextContent();

             return tagValue;
         }
         /**
          *
          * @param tagName
          * @return int tagValue
          */
         public int getIntValue(String tagName) {
             return Integer.parseInt(getTextValue(tagName));
         }
         /**
          *
          * @param tagName
          * @param tagValue
          */
         public void changeText(String tagName, String tagValue) {
             Element ele = (Element)dom.getElementsByTagName(tagName);
             ele.setTextContent(tagValue);
         }
         
}
