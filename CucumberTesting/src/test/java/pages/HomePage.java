package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonMethods.BaseTest;

public class HomePage extends BaseTest{
	
    public HomePage(WebDriver driver) { 
    	PageFactory.initElements(driver, this);
    }  

	 @FindBy(how = How.CSS, using = ".lnXdpd")
	 public WebElement _homePageLogo;
	 
	 @FindBy(how = How.CSS, using = ".gLFyf gsfi")
	 public WebElement _searchBox;
	 
	 @FindBy(how = How.XPATH, using = "(//input[@aria-label='Google Search'])[2]")
	 public WebElement _searchButton;
	 
	 @FindBy(how = How.XPATH, using = "//ul[@class='erkvQe']")
	 public WebElement _autosuggestiondisplay;
	 
	 @FindBy(how = How.XPATH, using = "//*[text()='duc']//b[text()='k']/ancestor::span")
	 public WebElement _clickautosuggestion;
	 
	 
	 
	 
	 public void TypeInSearchTxtBox(String _text) {
		 _searchBox.sendKeys(_text);

	 }
	 
	 public void ClearInSearchTxtBox() {
		 _searchBox.clear();

	 }
	 
	 public void ClickSearchButton() {
		 _searchButton.click();

	 }
	 
	 public boolean Logoisdisplayed() {
		return _homePageLogo.isDisplayed();

	 }
	 public boolean SearchBoxisdisplayed() {
		return _searchBox.isDisplayed();

	 }
	 public boolean AutoSuggestionisdisplayed() {
		return _autosuggestiondisplay.isDisplayed();

	 }
	 
	 public void ClickAutoSuggestion() {
		 _clickautosuggestion.click();

	 }
	 
	// driver.findElement(By.cssSelector(".gLFyf gsfi")).isDisplayed()
}
