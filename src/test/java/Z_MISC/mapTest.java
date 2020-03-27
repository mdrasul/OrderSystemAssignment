package Z_MISC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mapTest {

	
	static Map<String, List<String>> orderList = null;
	
	public static void main(String[] args) {

		
		orderList = new HashMap<String, List<String>>();
		
		
//		List<String> item = new ArrayList<String>();
//		item.add("P1");
//		item.add("Plan A");
//		orderList.put("O001", item);
//		
//		List<String> item2 = new ArrayList<String>();
//		item2.add("P2");
//		item2.add("Plan B");		
//		orderList.put("O002", item2);
//
//		
//		// Push A Duplicate Key - Not Happening 
//		List<String> item3 = new ArrayList<String>();
//		item3.add("P3");
//		item3.add("Plan C");
//		orderList.put("O003", item3);
//		
//
//		for(String key: orderList.keySet() ) {
//			System.out.println(key + " : " + orderList.get(key))  ;
//		}
		
		for(int i=0;i<3;i++) {
			// System.out.println(addProduct_Plan("00"+i,"P"+i, "Plan A"+i));
			System.out.println(addProduct_Plan("00"+i,"P", "Plan A")); // Try Adding a Duplicate 
		}
		
		
		
//		for(List<String> value: orderList.values() ) {
//			System.out.println(value.toString()) ;
//		}
		
	}
	
	
	
	public static String addProduct_Plan(String orderID,String product, String Plan) {

		List<String> item = new ArrayList<String>();
		item.add(product);
		item.add(Plan);

		// if the Order already exist with sample product & Plan
		for(String key: orderList.keySet() ) {
			//System.out.println(key + " : " + orderList.get(key));
			if(orderList.get(key).equals(new ArrayList<>(item))) {
				System.out.println("Product & Plan Already Exist for this Order ");
				return "Product & Plan Already Exist for this Order ";
			}
		}
		
		orderList.put(orderID, item);
		System.out.println(orderList.get(orderID));
		
		return "Successfully Added an order ..";
	}

}
