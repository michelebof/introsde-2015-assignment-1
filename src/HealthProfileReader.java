import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class HealthProfileReader {
		
	    Document doc;
	    XPath xpath;

	    public void loadXML() throws ParserConfigurationException, SAXException, IOException {

	        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	        domFactory.setNamespaceAware(true);
	        DocumentBuilder builder = domFactory.newDocumentBuilder();
	        doc = builder.parse("people.xml");

	        //creating xpath object
	        getXPathObj();
	    }

	    public XPath getXPathObj() {

	        XPathFactory factory = XPathFactory.newInstance();
	        xpath = factory.newXPath();
	        return xpath;
	    }


		/**
		 * The health profile reader gets information from the command line about
		 * weight and height and calculates the BMI of the person based on this
		 * parameters
		 * 
		 * @param args
		 * @throws XPathExpressionException 
		 * @throws IOException 
		 * @throws SAXException 
		 * @throws ParserConfigurationException 
		 */
		public static void main(String[] args)throws ParserConfigurationException, SAXException,
									IOException, XPathExpressionException{
			int argCount = args.length;
			HealthProfileReader test = new HealthProfileReader();
	        	test.loadXML();
			if (argCount == 0) {
				System.out.println("Give me at least a method.");
			} else {
				String method = args[0];
				if (method.equals("displayProfile")) {
					String personId = args[1];
					test.displayProfile(personId);				
				} else if (method.equals("displayHealthProfile")) {
					String personId = args[1];
					test.displayHealthProfile(personId);				
				}  else if (method.equals("all")) {
					test.displayAll();
				} else if (method.equals("displayProfilebyWeight")) {
					Double weight = Double.parseDouble(args[1]);
					String condition = args[2];
					test.displayProfilebyWeight(weight,condition);
				} else{
					System.out.println("The system did not find the method '"+method+"'");
				}
			}
		}

		private String getFirstname(String personId) throws XPathExpressionException{
			XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']/firstname/text()");
		        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		        return node.getTextContent();
		}
		
		private String getLastname(String personId) throws XPathExpressionException{
			XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']/lastname/text()");
		        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		        return node.getTextContent();
		}
		
		private String getBirth(String personId) throws XPathExpressionException{
			XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']/birthdate/text()");
		        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		        return node.getTextContent();
		}
		
		private double getWeight(String personId) throws XPathExpressionException{
			XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']/healthprofile/weight/text()");
		        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		        return  Double.parseDouble(node.getTextContent());
		}
		
		private double getHeight(String personId) throws XPathExpressionException{
			XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']/healthprofile/height/text()");
		        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		        return  Double.parseDouble(node.getTextContent());
		}
		
		private double getBmi(String personId) throws XPathExpressionException{
			XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']/healthprofile/bmi/text()");
		        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		        return Double.parseDouble(node.getTextContent());
		}	
		
		// function that display HealthProfile of the person with id=personid
		private void displayHealthProfile(String personId) throws XPathExpressionException {
			HelpProfile p = new HelpProfile();
			p.setFirstname(this.getFirstname(personId));
			p.setWeight(this.getWeight(personId));
			p.setHeight(this.getHeight(personId));
			p.setBmi(this.getBmi(personId));
			System.out.println(p.HealthProfiletoString());
		}
		
		//Function that display all the people in the XML
		private void displayAll() throws XPathExpressionException {
			//Save all the people id in a NodeList nodes
			XPathExpression expr = xpath.compile("//@id");
		        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		        //for each node in nodes execute displayProfile function with id in node 
		        for(int i = 0; i< nodes.getLength();i++){
		        	this.displayProfile(nodes.item(i).getTextContent());
		        }
		}
		
		//Function that display all the people that fulfill the condition
		private void displayProfilebyWeight(double weight, String condition) throws XPathExpressionException{
			//Save all the people id in a NodeList nodes that fulfill the condition
			XPathExpression expr = xpath.compile("//person[healthprofile/weight " + condition + "'" + weight + "']/@id");
		        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		        //for each node in nodes execute displayProfile function with id in node 
		        for(int i = 0; i< nodes.getLength();i++){
		        	this.displayProfile(nodes.item(i).getTextContent());
		        }
		}
		
		//Function that display the profile of the person given the personID
		private void displayProfile(String personId) throws XPathExpressionException {
			HelpProfile p = new HelpProfile();
			p.setFirstname(this.getFirstname(personId));
			p.setLastname(this.getLastname(personId));
			p.setBirthdate(this.getBirth(personId));
			p.setWeight(this.getWeight(personId));
			p.setHeight(this.getHeight(personId));
			p.setBmi(this.getBmi(personId));
			System.out.println(p.toString());
		}

	
}
