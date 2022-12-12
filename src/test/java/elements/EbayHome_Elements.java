package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHome_Elements {

    WebDriver driver;
    @FindBy(xpath = "//a[@id='gh-la']") public WebElement ebayLogo;
    @FindBy(xpath = "//input[@id='gh-btn']") public WebElement buton;
    @FindBy(xpath = "//input[@id='gh-ac']") public WebElement search;
    @FindBy(xpath = "//select[@id='gh-cat']/option") public List<WebElement> options;
    @FindBy(linkText = "Advanced") public WebElement advanced;



    public EbayHome_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
