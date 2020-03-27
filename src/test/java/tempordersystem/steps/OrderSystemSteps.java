package tempordersystem.steps;

import java.util.List;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderSystemSteps {

	
    KnowsTheDomain helper;
    static boolean isGlobalCollectionCleared;

	//User user;
	
    public OrderSystemSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Before
    public void beforeScenario(Scenario s) {
    	//System.out.println("Tag Name ======" + s.getSourceTagNames().toString());
    	if(s.getSourceTagNames().contains("@User2-Scenario") && isGlobalCollectionCleared==false) {
    		helper.getOrderCart().clear();
    		helper.getUserCoampanyList().clear();
    		isGlobalCollectionCleared=true;
    	}
    }
    
    
	@Given("^\"(.*?)\" place \"(.*?)\" for \"(.*?)\"$")
	public void place_for(String username, String order, String companyName){
		
		helper.getUser().setUser(username);
		helper.getUser().startOrder(helper.getOrder(), helper.getUserCoampanyList(),companyName);
		helper.getOrder().setOrderId(order);
	}

	@When("^Adding \"(.*?)\" & \"(.*?)\"$")
	public void add_for_plann(String productName, String planName){		
		helper.getUser().addItems(helper.getOrderCart(),productName,planName);
	}


	@Then("^system validate order :$")
	public void system_validate_order(DataTable orderDetails) {
		
		List<MyValueClass> expectation = orderDetails.asList(MyValueClass.class);
		
		// This will handle multiple Data Scenario 
		for (MyValueClass values : expectation) {
			String expectedScenarioOutCome = values.getValue().replaceAll("\"","");
			System.out.println("\tExpected From Gherkin 	: " + expectedScenarioOutCome);
			
			String actualScenarioOutcome = helper.getUser().getorderDetails();
			System.out.println("\tActual From Core System : " + actualScenarioOutcome);
			
	        Assert.assertEquals("Scenario Failed -", expectedScenarioOutCome, actualScenarioOutcome); 
		}
		
	}

	class MyValueClass {

		private final String forOrder;
		private final String rules;


		public MyValueClass(String v1, String v2) {
			forOrder = v1;
			rules = v2;
		}
		public String getValue() {
			return forOrder +" "+rules;
		}
	}

}
