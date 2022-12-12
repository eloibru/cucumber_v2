package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearch_Elements {

    WebDriver driver;
    @FindBy(xpath = "//a[@id='gh-la']") public WebElement ebayLogo;

    @FindBy(xpath = "//input[@id='_nkw']") public WebElement searchCriteria;

    @FindBy(xpath = "//input[@id='_ex_kw']") public WebElement exclude;
    @FindBy(xpath = "//input[@name='_udlo']") public WebElement minPrice;
    @FindBy(xpath = "//input[@name='_udhi']") public WebElement maxPrice;


    @FindBy(xpath = "//button[@id='searchBtnLowerLnk']") public WebElement advancedSearchButon;

    public EbayAdvancedSearch_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
