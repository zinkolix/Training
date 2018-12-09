package exemel;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class GreetingSaxParser {
	public static void main(String[] args) throws Exception {
//		String path = "greeting.xml";
		String path = "employee.xml";
//		GreetingHandler handler = new GreetingHandler();
		EmployeeHandler handler = new EmployeeHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		parser.parse(path, handler);
	}
}
