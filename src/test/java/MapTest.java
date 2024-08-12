import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	
		HashMap<Integer, String> empMap = new HashMap<Integer, String>();
		empMap.put(100, "top");
		empMap.put(200, "bottom");
		empMap.put(300, "left");

		empMap.forEach((k,v)-> System.out.println(k + ":" + v));
		
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("zebra", "top");
		linkedHashMap.put("parrot", "bottom");
		linkedHashMap.put("apple", "left");
		
		linkedHashMap.forEach((k,v)-> System.out.println(k + ":" + v));
		
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("zebra", "top");
		treeMap.put("parrot", "bottom");
		treeMap.put("apple", "left");
		
		treeMap.forEach((k,v)-> System.out.println(k + ":" + v));
	}

}
