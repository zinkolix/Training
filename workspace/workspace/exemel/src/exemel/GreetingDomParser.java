package exemel;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;


public class GreetingDomParser {
	
	public static void main(String[] args) throws Exception {
		String path = "greeting.xml";
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(path);
		Node pi = doc.getFirstChild();			//doc represent "/" elements
		System.out.println(pi.getNodeName());	//pi is processing instruction

		
		Node root = pi.getNextSibling();		//root is greeting
		System.out.println(root.getNodeName());
		
		Node msg = root.getFirstChild().getNextSibling();
		System.out.println(msg.getNodeName());
		System.out.println(msg.getFirstChild().getNodeValue());
		
		Node person = msg.getNextSibling().getNextSibling();
		System.out.println(person.getNodeName());
		System.out.println(person.getFirstChild().getNodeValue());
	}
}
