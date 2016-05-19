/**
 * 
 */
package gow.demo.hr;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * 
 * Parses XML file of employee data and outputs formatted report
 *
 */

public class MEmpDataXMLParseDOM {
	
	public static void main (String[] args) {
		
		try {
			File inputFile = new File ("src/gow/demo/hr/Employee_Data.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			// create a document object from the inputfile
			Document doc = dBuilder.parse (inputFile);
			
			// normalize the document which internally removes unnecessary carriage returns within elements
			doc.getDocumentElement().normalize();
			
			// find the root element (employees) and print it
	        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	        
	        // get the list of employee 'blocks' in the XML as a 'NodeList' (a list of objects of Node interface)
	        // The Node interface is the primary datatype for the entire Document Object Model
	        NodeList nodeList = doc.getElementsByTagName("Employee");
	        
	        // loop through nodes in the nodeList and print elements
	        for (int i = 0; i < nodeList.getLength(); i++) {
	        	
	        	// get the node - aka employee record
	        	Node currentNode = nodeList.item(i);
	        	//System.out.println("\nCurrent Element:" + currentNode.getNodeName());
	        	
	        	// Get the remaining attributes of the node
	        	if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	        		Element nodeElement = (Element) currentNode;
	        		
		        	System.out.println("\nName :" + nodeElement.getElementsByTagName("name").item(0).getTextContent());
		        	
		        	//NOTE: The above line prints one value for a tag. If multiple tags are there, then loop through them
		        	//      with another 'length' and loop - length with: nodeElement.getElementsByTagName("name").getLength()

		        	System.out.println("Dept :" + nodeElement.getElementsByTagName("dept").item(0).getTextContent());
		        	System.out.println("Join Date :" + nodeElement.getElementsByTagName("joindate").item(0).getTextContent());

		        	
	        	}
	        		        	
	        }
	        
	        
		}
		catch (Exception e) {
	         e.printStackTrace();
	      }
	}

}
