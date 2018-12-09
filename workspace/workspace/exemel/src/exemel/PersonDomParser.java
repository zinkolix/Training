package exemel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class PersonDomParser {

	public static void main(String[] args) throws Exception {
		String path = "person.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(path);
		Node root = doc.getFirstChild();			//doc represent "/" elements
		System.out.println(root.getNodeName());	
		
		displayInfo(root.getFirstChild());

	}

	private static void displayInfo(Node node) {
		if(node.getNodeType() != Node.TEXT_NODE){
			System.out.print(node.getNodeName() + ":");
			Node child = node.getFirstChild();
			if(child != null)
				System.out.println(child.getNodeValue());
		}
		
		if(node.getNextSibling() != null)
			displayInfo(node.getNextSibling());
		
	}

}
