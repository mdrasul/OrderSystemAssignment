package tempordersystem.core;

import java.util.List;
import java.util.Map;

public class User {


	String user;
	Order order;
	String companyName;
	String orderStatus="Success";

	int userOrderCount=0;
	boolean userOrderError;


	// Constructor 
	public User() {
	}

	// Getters & Setters
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	// Users Order Processing 
	public void startOrder(Order order, List<String> userCompanyList, String companyName) {

		this.order = order;
		this.companyName = companyName;
		
		if(!usersCompanyCheck(userCompanyList, companyName)) {
			orderStatus="One User One Company Only..";
			return;
		}

		// Order started Initialize Order System & COmpany 
		userCompanyList.add(companyName);
	}
	
	public void addItems(Map<String, List<String>> orderCart, String productName, String planName) {

		order.setProductName(productName);
		order.setPlanName(planName);

		if(!orderStatus.equals("Success")) {			
			return; // Already Error We can't Move To Add Items 
		}

		if(!order.itemAddedToCart(orderCart, companyName)) {
			orderStatus = "Product & Plan Already Exist for this Order";
			return;
		}

		if(orderCart.size()>3) { // here 2 is 2 as list start from zwro 
			orderStatus="Maximum order Reached User ...";
			return;
		}

			
	}

	// Order Validator User Points Of View 
	public boolean usersCompanyCheck(List<String> companiesList, String companyName) {	

		if(!(companiesList.size()==0)) {
			if(!companiesList.get(0).equals(companyName)) {
				userOrderError=true;
				return false;
			}
		}

		return true;
	}


	// Return Back the Order Status 
	public String getorderDetails() {
		return user +" "+ order.orderId + " " +order.getProductName() + " " + order.getPlanName() + " " +companyName + " " +orderStatus;
	}

}
