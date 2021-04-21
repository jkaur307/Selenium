package stepDefinition;
import org.testng.Assert;

import commonMethods.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultsPage;

public class GoogleSearchSteps extends BaseTest{
	

	public HomePage homepage = new HomePage(driver);
	public SearchResultsPage searchresultspage = new SearchResultsPage(driver);

	
	@Given("the user is in Google page")
	public void the_user_is_in_google_page() {
		BrowserInitialization();
		NavigateToURL(URL);
	}

	@Then("the page should display google logo")
	public void the_page_should_display_google_logo() {
		 Assert.assertTrue(homepage.Logoisdisplayed(), "Google logo is not displayed");  

	}

	@Then("the page sholud have a search box")
	public void the_page_sholud_have_a_search_box() {		
		  Assert.assertTrue(homepage.SearchBoxisdisplayed(), "Google search box is not displayed");
	}

	@When("the user searches {string} in the google search box")
	public void the_user_searches_in_the_google_search_box(String string) {
		homepage.ClearInSearchTxtBox();
		homepage.TypeInSearchTxtBox(string);
	}

	@When("click the search button")
	public void click_the_search_button() {		
		homepage.ClickSearchButton();
	}

	@Then("results should be displayed")
	public void results_should_be_displayed() {		
		searchresultspage.WaittillPageLoads();
	    Assert.assertTrue(searchresultspage.SearchResultsisdisplayed(), "Search results should not be zero for valid search");
	}

	@Then("the searched word {string} should be mentioned in the results")
	public void the_searched_word_should_be_mentioned_in_the_results(String string) {	    
	    Assert.assertTrue(searchresultspage.ValidateResultList(string)>=5,"Search results bringing wrong results");
	}

	@Then("google should give auto suggestions")
	public void google_should_give_auto_suggestions() {
		homepage.ClearInSearchTxtBox();
		homepage.TypeInSearchTxtBox("duc");
		Assert.assertTrue(homepage.AutoSuggestionisdisplayed(), "Auto suggestions are not displayed");
	}

	@Then("the word {string} should be mentioned in the auto suggestions")
	public void the_word_should_be_mentioned_in_the_auto_suggestions(String string) {
	  Assert.assertTrue(homepage.AutoSuggestionisdisplayed(), "The suggestions should display the keyword duck");	 
	  }

	@When("click {string} from the auto suggestions")
	public void click_from_the_auto_suggestions(String string) {
		homepage.ClickAutoSuggestion();		  
	}
}
