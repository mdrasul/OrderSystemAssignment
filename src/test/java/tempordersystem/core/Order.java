package tempordersystem.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

	String orderId;
	String productName; 
	String planName;


	// Getter & Setter 
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public boolean itemAddedToCart(Map<String, List<String>> orderCart, String companyName) {
						
		if(companyName.equals("CompanyV1")) {
			List<String> item = new ArrayList<String>();
			item.add(productName);
			item.add(planName);
			// if the Order already exist with sample product & Plan
			for(String key: orderCart.keySet() ) {
				if(orderCart.get(key).equals(new ArrayList<>(item))) {
					return false;
				}
			}
			
			if(!(orderCart.size()>3)) {
				orderCart.put(orderId, item);	
			}
			
		} else if(companyName.equals("CompanyV2")) {
			List<String> item = new ArrayList<String>();
			item.add(planName);
			item.add(productName);
			// if the Order already exist with sample product & Plan
			for(String key: orderCart.keySet() ) {
				if(orderCart.get(key).equals(new ArrayList<>(item))) {
					return false;
				}
			}
			if(!(orderCart.size()>3)) {
				orderCart.put(orderId, item);	
			}		}
		
		return true;
	}

}
