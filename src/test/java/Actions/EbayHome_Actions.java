package Actions;

import elements.EbayHome_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.CommonsSteps;

import java.util.List;

public class EbayHome_Actions {

    private WebDriver webDriver;
    private EbayHome_Elements elements;

    public EbayHome_Actions(CommonsSteps commonsSteps) {
        this.webDriver = commonsSteps.getWebDriver();
        elements = new EbayHome_Elements(webDriver);
    }

    public void clickOnAdvancedLink(){
        elements.advanced.click();
    }

    public void clickOnAdvancedLink(String s){
         webDriver.findElement(By.linkText(s)).click();
    }

    public void clickOnLogo(){
        elements.ebayLogo.click();
    }

    public void clickOnButon(){
        elements.buton.click();
    }


    public void search(String s){
        elements.search.sendKeys(s);
    }

    public List<WebElement> getOptions() {
        return elements.options;
    }


}
