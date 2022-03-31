import java.util.HashSet;

public class Main extends RD {
	
	private String databaseTitle;
	private HashSet<String> attributeNames;
	
	public Main(String databaseTitle, HashSet<String> attributeNames) throws NullPointerException {
		super(databaseTitle, attributeNames);
		// TODO Auto-generated constructor stub
		this.databaseTitle = databaseTitle;
		this.attributeNames = attributeNames;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		Main table = new Main("Siddhant's Table", new HashSet<String>());
//		System.out.println(table.addAttribute("Jesus", 10));
//		System.out.println(table.addAttribute("Jesus", 20));
//		System.out.println(table.addAttribute("Jesus", 30));
//		System.out.println(table.addAttribute("Jesus", 40));
//		System.out.println(table.addAttribute("Jesus", 50));
//		System.out.println(table.addAttribute("Jesus", 60));
//		System.out.println(table.addAttribute("Jesus", 70));
//		
//		System.out.println(table.toString());
		
		for(int i = 0; i < 100; i++) {
			String key = "KeyNumero" + i + "X".repeat(i%10);
			table.addAttribute(key, i);;
		}
		System.out.println(table.toString());

	}

}
