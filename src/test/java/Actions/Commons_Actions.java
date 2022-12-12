package Actions;

import elements.Commons_Elements;
import org.openqa.selenium.WebDriver;
import steps.CommonsSteps;

import java.net.MalformedURLException;

public class Commons_Actions {

    WebDriver driver;

    Commons_Elements commons_elements;

    public Commons_Actions(CommonsSteps commonsSteps) {
        this.driver = commonsSteps.getWebDriver();
        commons_elements = new Commons_Elements(driver);
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl(){
       return  driver.getCurrentUrl();
    }

    public String getTitle(){
      return  driver.getTitle();
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

    public int getItemCount(){
        return Integer.parseInt(commons_elements.itemCount.getText().replace(",", ""));
    }
    public void clickGdpr(){
        if(commons_elements.gdpr.isDisplayed()){
            commons_elements.gdpr.click();
        }
    }
}
