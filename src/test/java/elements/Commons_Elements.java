package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Commons_Elements {
    WebDriver driver;


    public Commons_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath =  "//button[@id='gdpr-banner-accept']") public WebElement gdpr;

    @FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child") public WebElement itemCount;

}
