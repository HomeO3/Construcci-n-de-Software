package net.osgg.xmldomparser;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import java.util.logging.Level;

/**
 * Homero Ojeda     6834
 * Kevin Espinoza   6820
 * Andrés Alcoser   6760
 * Daniel Tene      6842
 * Héctor Nieto     6832
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String poblacion = "poblacion";
        List<Países> ListaPaises = new ArrayList<Países>();
        ListaPaises.add(new Países("Paraguay",3580888,3463751));
        ListaPaises.add(new Países("Suriname",292255,289108));
        ListaPaises.add(new Países("Guyana",393271,389504));
        ListaPaises.add(new Países("Bolivia",5779611,5733491));
        ListaPaises.add(new Países("Ecuador",8690487,8683170));
        ListaPaises.add(new Países("Perú",16148241,16362221));
        ListaPaises.add(new Países("French Guiana",143766,147057));
        ListaPaises.add(new Países("Chile",9341774,9610261));
        ListaPaises.add(new Países("Venezuela",14045228,14470601));
        ListaPaises.add(new Países("Brazil",103733160,107316359));
        ListaPaises.add(new Países("Colombia",24713193,25626250));
        ListaPaises.add(new Países("Argentina",21841415,22939260));
        ListaPaises.add(new Países("Uruguay",1671889,1789842));
        
        try{
            crearXML(poblacion,ListaPaises);
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        DomParser dp = new DomParser("poblacion.xml");
        try {
			dp.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
     public static void crearXML(String poblacion, List<Países> ListaPaises) throws TransformerConfigurationException, ParserConfigurationException, TransformerException{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try{
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                Document document = implementation.createDocument(null,poblacion,null);
                document.setXmlVersion("1.0");
                
                
                //Nodo raiz
                Element raiz = document.getDocumentElement();
                for (int i = 0; i < ListaPaises.size(); i++) {
                    Element itemNode = document.createElement("País");
                    
                    Element countryNode = document.createElement("Country");
                    Text nodeCountryValue = document.createTextNode(""+ListaPaises.get(i).getPaís());
                    countryNode.appendChild(nodeCountryValue);
                    
                    Element femalesNode = document.createElement("Females");
                    Text nodeFemalesValue = document.createTextNode(""+ListaPaises.get(i).getFemales());
                    femalesNode.appendChild(nodeFemalesValue);
                    
                    
                    Element malesNode = document.createElement("Males");
                    Text nodeMalesValue = document.createTextNode(""+ListaPaises.get(i).getMales());
                    malesNode.appendChild(nodeMalesValue);
                    
                    itemNode.appendChild(countryNode);
                    itemNode.appendChild(femalesNode);
                    itemNode.appendChild(malesNode);
                    
                    raiz.appendChild(itemNode);
                }
                //genera xml
                Source source = new DOMSource(document);
                //direccion 
                Result result = new StreamResult(new java.io.File(poblacion +".xml"));
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
                
            }catch(ParserConfigurationException e){
         
                
         
            }
     }

            
        
}

           

