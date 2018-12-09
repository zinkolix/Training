package exemel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler {

	private int count;
	private double total;
	private boolean flag;
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		if(flag == true){
			total += Double.parseDouble(str);
			flag = false;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Total of " + count + " employee are paid " + total);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("employee"))
			count ++;
		if(qName.equalsIgnoreCase("salary"))
			flag = true;
		if(attributes != null)
		System.out.println("Arrtibutes: " + attributes);}

	
	
}
