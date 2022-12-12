package Actions;

import elements.EbayAdvancedSearch_Elements;
import org.openqa.selenium.WebDriver;
import steps.CommonsSteps;

public class EbayAdvancedSearch_Actions {

    private WebDriver webDriver;
    private EbayAdvancedSearch_Elements elements;

    public EbayAdvancedSearch_Actions(CommonsSteps commonsSteps) {
        this.webDriver = commonsSteps.getWebDriver();
        elements = new EbayAdvancedSearch_Elements(webDriver);
    }


    public void clickOnLogo(){
        elements.ebayLogo.click();
    }
    public void clickAdvanceSearchButon(){
       if(elements.advancedSearchButon.isDisplayed()){
           elements.advancedSearchButon.click();
       }
    }
    public void searchItem(String item){
        elements.searchCriteria.sendKeys(item);
    }
    public void excludeItem(String exclude){
        elements.exclude.sendKeys(exclude);
    }
    public void setMinPrice(String minPrice){
        elements.minPrice.sendKeys(minPrice);
    }
    public void setMaxPrice(String maxPrice){
        elements.maxPrice.sendKeys(maxPrice);
    }


    public void search(String include, String exclude, String minPrice, String maxPrice){
        searchItem(include);
        excludeItem(exclude);
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);

    }

}
