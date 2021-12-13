package net.osgg.xmlsaxparser;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomHandler extends DefaultHandler {
    boolean pais = false;
    boolean females= false;
    boolean males = false;
    int a=0;
    int b=0;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("(starts element:" + qName + ")");
        /*if (qName.equalsIgnoreCase("Country")) {
            String id = attributes.getValue("empid");
            System.out.println("empid: " + id);
        }
        */
        if (qName.equalsIgnoreCase("Country")) {
            pais= true;
        }
        if (qName.equalsIgnoreCase("Females")) {
            females = true;
        }
        if (qName.equalsIgnoreCase("Males")) {
            males = true;
        }
      
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
       System.out.println("");
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
       
        if (pais) {
            System.out.println("País:  " + new String(ch, start, length));
            pais = false;
        }
        if (females) {
            System.out.println("Females: " + new String(ch, start, length));
            a = Integer.parseInt(new String(ch, start, length));  
            females = false;
        }
        if (males) {
            System.out.println("Males : " + new String(ch, start, length));
            b = Integer.parseInt(new String(ch, start, length));
           System.out.println("Total: "+ (a+b));
            males = false;
        }
        System.out.print("");
       
    }
    
    
}
