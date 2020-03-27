package tempordersystem.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tempordersystem.core.Company;
import tempordersystem.core.Order;
import tempordersystem.core.User;

public class KnowsTheDomain {
	private User user;
	private Order order;
	private Company company;
	public static Map<String, List<String>> orderCart;
	public static List<String> userCompanyList;
	
    boolean isGlobalCollectionCleared;

	    
    
	public List<String> getUserCoampanyList(){
		if (userCompanyList == null){
			userCompanyList = new ArrayList<String>();
		}
		return userCompanyList;
	}

	
	public Map<String, List<String>> getOrderCart(){
		if (orderCart == null){
			orderCart = new HashMap<String, List<String>>();
		}
		return orderCart;
	}

	public User getUser() {
		if (user == null){
			user = new User();
		}
		return user;
	}

	public Order getOrder() {
		if (order == null){
			order = new Order();
		}
		return order;
	}

	public Company getCompany() {
		if (company == null){
			company = new Company();
		}
		return company;
	}
}
