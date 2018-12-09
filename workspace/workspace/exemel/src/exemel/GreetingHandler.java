package exemel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GreetingHandler extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch,start,length);
		if(str.trim().length()>0)
		System.out.println("Data: " + str);
	}

	@Override
	public void endDocument() throws SAXException {
			System.out.println("Document ended");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("End of element: "  + qName);
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
			System.out.println("Processing instruction: " + data);
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document Begun");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println("Start of element: " + qName);
	}

}
