import java.util.HashMap;
import java.util.HashSet;

/**
 * this is an abstract class detailing the different parts of the java relational database
 */
/**
 * @author SiddhantSingh-dev
 * @date 3/30/22
 */
public abstract class RD {
	
	private String databaseTitle; 
	private HashSet<String> attributeNames;
	
	private HashMap<String, Node> table;	//String will be the attribute name, Node will be the attribute
	private int lengthOfLongestAttribute = Integer.MIN_VALUE;
	
	public RD(String databaseTitle, HashSet<String> attributeNames) throws NullPointerException {
		if(databaseTitle == null) throw new NullPointerException("database title may not be null.");
		if(attributeNames == null) throw new NullPointerException("attributes may not be null.");
		this.databaseTitle = databaseTitle;
		this.attributeNames = attributeNames;
		
		this.table = new HashMap<String, Node>();
	}

	public String getDatabaseTitle() {
		return databaseTitle;
	}

	public HashSet<String> getAttributeNames() {
		return attributeNames;
	}
	
	public void getAttribute(String attribute) throws NullPointerException{
		if(!this.attributeNames.contains(attribute))
			throw new NullPointerException("attribute " + attribute + " does not exist.");
		else {
			this.table.get(attribute);
		}
	}
	
	public Object addAttribute(String attribute, Object value) {
		if(attributeNames.contains(attribute))	{
			System.out.printf("attribute {%s} already exists.\n", attribute);
			Object ret = table.get(attribute);
			table.put(attribute, new Node(value));
			
			return ret;	//returns previous value
		}
		else {
			if(attribute.length() > lengthOfLongestAttribute)
				lengthOfLongestAttribute = attribute.length();
			attributeNames.add(attribute);
			table.put(attribute, new Node(value));
			System.out.printf("attribute {%s} added.\n", attribute);
			
			return null; //returns previous value
		}
	}
	
	@Override 
	public String toString() {
		String str = "";
		for(String key : table.keySet())
			str += key + (" ").repeat(lengthOfLongestAttribute - key.length()) + "| " + table.get(key).toString() + "\n";
		return str.trim();
	}
}

class Node {
	Object value;
	
	public Node(Object value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "attribute value: " + value.toString();
	}
}
