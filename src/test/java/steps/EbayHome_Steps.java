package steps;

import Actions.Commons_Actions;
import Actions.EbayHome_Actions;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static org.junit.Assert.fail;

public class EbayHome_Steps {



    Commons_Actions commons_actions;
    EbayHome_Actions ebayHome_actions;

    private ObjectMapper objectMapper = new ObjectMapper();


    public EbayHome_Steps( Commons_Actions commons_actions, EbayHome_Actions ebayHome_actions) {
        this.commons_actions = commons_actions;
        this.ebayHome_actions = ebayHome_actions;
    }




    @Given("I am on ebay home page")
    public void i_am_on_ebay_home_page() throws MalformedURLException {
        commons_actions.maximize();
        commons_actions.goToUrl("https://www.ebay.com");
    }
    @When("I click on logo")
    public void i_click_on_logo() {
        commons_actions.maximize();
        ebayHome_actions.clickOnLogo();
    }

    @Then("I navigate to the Ebay advanced search page")
    public void i_navigate_to_the_ebay_advanced_search_page() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = commons_actions.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl))
            fail("Page " + actualUrl + " not navigat to " + expectedUrl);
    }

    @When("I click on advanced search")
    public void i_click_advanced_search(){
        ebayHome_actions.clickOnAdvancedLink();
    }
    @Then("I navigate to ebay home page")
    public void i_navigate_to_ebay_home_page() {
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = commons_actions.getCurrentUrl();
        if(!actualUrl.equals(expectedUrl))
            fail("Page " + actualUrl + " not navigat to " + expectedUrl);
    }

    @When("I search for {string}")
    public void i_search_for_iphone(String st) throws InterruptedException {
        ebayHome_actions.search(st);
        Thread.sleep(1000);
        ebayHome_actions.clickOnButon();
    }

    @When("I search for {string} in category {string}")
    public void i_search_for_in_category(String st, String string2) throws InterruptedException {
        ebayHome_actions.search(st);
        for(WebElement element : ebayHome_actions.getOptions()){
            if(element.getText().toLowerCase().trim().equals(string2.toLowerCase())){
                element.click();
                break;
            }
        }
        Thread.sleep(1000);
        ebayHome_actions.clickOnButon();
    }

    @Then("I validate at least {int} items are present")
    public void i_validate_at_least_items_are_present(int items) {
        if(commons_actions.getItemCount()<items)
            fail("Item is less then exepcted");

    }

    @When("I click on {string}")
    public void i_click_on(String string) {
        ebayHome_actions.clickOnAdvancedLink(string);
    }

    @Then("I navigate to {string} and title contains {string}")
    public void i_navigate_to_and_title_contains(String expectedUrl, String expectedTitle) {
        String actualUrl = commons_actions.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl))
            fail("Page " + actualUrl + " not navigat to " + expectedUrl);
        commons_actions.getTitle().trim().toLowerCase().contains(expectedTitle.toLowerCase());

        }
    }
