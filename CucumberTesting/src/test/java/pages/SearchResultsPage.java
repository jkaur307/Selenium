package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonMethods.BaseTest;

public class SearchResultsPage extends BaseTest{
	
    public SearchResultsPage(WebDriver driver) { 
    	PageFactory.initElements(driver, this);
    }  
    
	 @FindBy(how = How.XPATH, using = "//h3[contains(@class,'LC20')")
	 public List<WebElement> _resultList;
	 
	 @FindBy(how = How.XPATH, using = "//h3[contains(@class,'LC20')]")
	 public WebElement _searchResults;


	 public void WaittillPageLoads() {
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
	 }
	 public boolean SearchResultsisdisplayed() {
		return _searchResults.isDisplayed();

	 }
	 
	 public int ValidateResultList(String _searchText) {
		    int i=0;
		    // this are all the links you like to visit
		    for (WebElement webElement : _resultList)
		    {
		        if (webElement.getText().toLowerCase().contains(_searchText)) {
		        	i=i+1;
		        }
		    }
		 return  i;
	 }
}
