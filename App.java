package net.osgg.xmlsaxparser;

/**
 * Homero Ojeda 6834
 * Daniel Tene 6842
 * Héctor Nieto 6832
 * Kevin Espinoza 6820
 * Andrés Alcoser 6760
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SaxParser sp = new SaxParser("poblacion.xml");
        try {
			sp.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
